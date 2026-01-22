#!/bin/sh

set -e

echo "Generating TLS certificate and key for distribution..."

mkdir -p "$XDG_CONFIG_HOME/containers/distribution/certs"
openssl req -x509 -newkey ec \
    -pkeyopt ec_paramgen_curve:P-256 \
    -keyout "$XDG_CONFIG_HOME/containers/distribution/certs/domain.key" \
    -out "$XDG_CONFIG_HOME/containers/distribution/certs/domain.crt" \
    -days 365 \
    -nodes \
    -subj '/C=US/ST=Minnesota/L=St. Paul/O=Closed Circuit Consulting/OU=R&D/CN=localhost/emailAddress=unitexe70@gmail.com' \
    -addext 'subjectAltName=DNS:localhost,IP:127.0.0.1,IP:::1'

echo "Setting permissions on generated artifacts..."

chmod 644 "$XDG_CONFIG_HOME/containers/distribution/certs/domain.key"
chmod 644 "$XDG_CONFIG_HOME/containers/distribution/certs/domain.crt"

echo "Adding CA to user containers trust store..."

mkdir -p "$XDG_CONFIG_HOME/containers/localhost:5000/"
cp "$XDG_CONFIG_HOME/containers/distribution/certs/domain.crt" "$XDG_CONFIG_HOME/containers/localhost:5000/ca.crt"

echo "Registry TLS configuration created and ready for use"
