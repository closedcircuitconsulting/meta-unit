#!/bin/sh

set -e

echo "Generating TLS certificate and key for local registry..."

mkdir -p /etc/registry
openssl req -x509 -newkey ec \
    -pkeyopt ec_paramgen_curve:P-256 \
    -keyout /etc/registry/domain.key \
    -out /etc/registry/domain.crt \
    -days 365 \
    -nodes \
    -subj '/C=US/ST=Minnesota/L=St. Paul/O=Closed Circuit Consulting/OU=/CN=localhost/emailAddress=unitexe70@gmail.com' \
    -addext 'subjectAltName=DNS:localhost,IP:127.0.0.1,IP:::1'

echo "Setting permissions on generated artifacts..."

chmod 640 /etc/registry/domain.key
chmod 644 /etc/registry/domain.crt

echo "Adding CA to system trust store..."

mkdir -p /usr/local/share/ca-certificates
cp /etc/registry/domain.crt /usr/local/share/ca-certificates/registry.crt
update-ca-certificates

echo "Adding CA to containers trust store..."

mkdir -p /etc/containers/certs.d/localhost:5000/
cp /etc/registry/domain.crt /etc/containers/certs.d/localhost:5000/ca.crt

echo "Registry TLS configuration created and ready for use"
