The keys in this directory are for testing purposes only, never use them in a real application.

## RSA Test Keys

The `rsatest.priv.pem` RSA private key file was generated via the following:

    $ openssl genrsa -out rsatest.priv.pem 2048
    
That private key's corresponding `rsatest.pub.pem` public key was derived via:

    $ openssl rsa -in rsatest.priv.pem -pubout > rsatest.pub.pem
    
The public key was then moved to the example origin application's 
`<project root>/origin/src/main/resources` directory since the gateway
only needs the private key to create signatures (and the origin app
needs the public key to verify signatures).
    

## Elliptic Curve Test Keys

If you wanted to use Elliptic Curve asymmetric keys instead of the RSA
ones already provided, you can do that via the following:

    $ openssl ecparam -name secp384r1 -genkey -noout -out secp384r1.priv.pem
    
This creates an Elliptic Curve private key file named 
`secp384r1.priv.pem` that reflects the EC curve name `secp384r1` 
(for JWT's `ES256`, `ES384` and `ES512` signature algorithms, the 
respective OpenSSL curve names are `secp256k1`, `secp384r1` and `secp512r1`).

You then have to indicate this file should be used in `application.yml`:

    stormpath:
      zuul:
        account:
          header:
            jwt:
              key:
                resource: classpath:sec384r1.priv.pem
      

Once you have the `sec384r1.priv.pem` private key, you can derive its 
corresponding public key via the following:

    $ openssl ec -in secp384r1.priv.pem -pubout -out secp384r1.pub.pem
    
This creates the corresponding public key file named `secp384r1.pub.pem`.
You can then move this public key file to the example origin application's 
`<project root>/origin/src/main/resources` directory since the gateway
only needs the private key to create signatures (and the origin app
needs the public key to verify signatures).