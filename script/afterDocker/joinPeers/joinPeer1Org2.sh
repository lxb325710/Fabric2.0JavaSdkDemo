CORE_PEER_LOCALMSPID=org2MSP
CORE_PEER_ADDRESS=peer1-org2.txhy.com:7551
CORE_PEER_MSPCONFIGPATH=/usr/local/home/org2/admin/msp
CORE_PEER_TLS_CERT_FILE=/usr/local/home/org2/peer1/tls-msp/signcerts/cert.pem
CORE_PEER_TLS_KEY_FILE=/usr/local/home/org2/peer1/tls-msp/keystore/key.pem
CORE_PEER_TLS_ROOTCERT_FILE=/usr/local/home/org2/peer1/tls-msp/tlscacerts/tls-0-0-0-0-7052.pem

CHANNEL_NAME=${1}
cd /usr/local/home/configtx/channel-artifacts/$CHANNEL_NAME

peer channel join -b $CHANNEL_NAME.block
