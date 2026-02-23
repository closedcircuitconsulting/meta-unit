#!/bin/sh

XDG_LOCAL_HOME="/home/$TARGET_USR/.local"
XDG_CONFIG_HOME="/home/$TARGET_USR/.config"

set -e

echo "Cleaning up any previous artifacts..."

rm -f "$XDG_CONFIG_HOME/containers/distribution/certs/domain.key"
rm -f "$XDG_CONFIG_HOME/containers/distribution/certs/domain.crt"
rm -f /usr/local/share/ca-certificates/registry.crt
rm -f "/etc/containers/certs.d/$DISTRIBUTION_REGISTRY_URL/ca.crt"
rm -f "$XDG_CONFIG_HOME/containers/certs.d/$DISTRIBUTION_REGISTRY_URL/ca.crt"
rm -f "$XDG_LOCAL_HOME/share/distribution/certs-ready-signal"

echo "Creating necessary system directories..."

mkdir -p "/etc/containers/certs.d/$DISTRIBUTION_REGISTRY_URL/"
mkdir -p /usr/local/share/ca-certificates

echo "Creating necessary user directories..."

mkdir -p "$XDG_CONFIG_HOME/containers/distribution/certs"
mkdir -p "$XDG_CONFIG_HOME/containers/certs.d/$DISTRIBUTION_REGISTRY_URL"
mkdir -p "$XDG_LOCAL_HOME/share/distribution"

echo "Generating TLS certificate and key for local registry..."

openssl req -x509 -newkey ec \
    -pkeyopt ec_paramgen_curve:P-256 \
    -keyout "$XDG_CONFIG_HOME/containers/distribution/certs/domain.key" \
    -out "$XDG_CONFIG_HOME/containers/distribution/certs/domain.crt" \
    -days 365 \
    -nodes \
    -subj '/C=US/ST=Minnesota/L=St. Paul/O=Closed Circuit Consulting/OU=R&D/CN=localhost/emailAddress=unitexe70@gmail.com' \
    -addext 'subjectAltName=DNS:localhost,IP:127.0.0.1,IP:::1'

echo "Setting permissions on generated artifacts..."

chown $TARGET_USR:$TARGET_USR "$XDG_CONFIG_HOME/containers/distribution/certs/domain.key"
chown $TARGET_USR:$TARGET_USR "$XDG_CONFIG_HOME/containers/distribution/certs/domain.crt"
chmod 640 "$XDG_CONFIG_HOME/containers/distribution/certs/domain.key"
chmod 644 "$XDG_CONFIG_HOME/containers/distribution/certs/domain.crt"

echo "Adding CA to system trust store..."

cp -f "$XDG_CONFIG_HOME/containers/distribution/certs/domain.crt" /usr/local/share/ca-certificates/registry.crt
update-ca-certificates

echo "Adding CA to containers trust store..."

cp -f "$XDG_CONFIG_HOME/containers/distribution/certs/domain.crt" "/etc/containers/certs.d/$DISTRIBUTION_REGISTRY_URL/ca.crt"

echo "Adding CA to user containers trust store..."

chown -R $TARGET_USR:$TARGET_USR "$XDG_CONFIG_HOME/containers/certs.d"
chmod 755 "$XDG_CONFIG_HOME/containers/certs.d/$DISTRIBUTION_REGISTRY_URL"

cp -f "$XDG_CONFIG_HOME/containers/distribution/certs/domain.crt" "$XDG_CONFIG_HOME/containers/certs.d/$DISTRIBUTION_REGISTRY_URL/ca.crt"
chown $TARGET_USR:$TARGET_USR "$XDG_CONFIG_HOME/containers/certs.d/$DISTRIBUTION_REGISTRY_URL/ca.crt"
chmod 644 "$XDG_CONFIG_HOME/containers/certs.d/$DISTRIBUTION_REGISTRY_URL/ca.crt"

echo "Creating signal file..."

chown -R $TARGET_USR:$TARGET_USR "$XDG_LOCAL_HOME/share/distribution"
touch "$XDG_LOCAL_HOME/share/distribution/certs-ready-signal"
chmod 644 "$XDG_LOCAL_HOME/share/distribution/certs-ready-signal"

echo "Registry TLS configuration created and ready for use"
