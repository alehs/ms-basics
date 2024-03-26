
### In scope of this task:
- Created custom User Details Service (DomainUserDetailsService) which validates user not blocked and activated and loads users with authorities
- BruteForceProtectionService - blocks user for 1 min after 3 unsuccessful login attempts
- User Secrets API /secrets provides One-time secret sharing functionality 

execute:

`POST /secrets
body {
"secret": "this is my secret"
}
`

response should be like:

`{
"links": [
    {
        "first": "self",
        "second": "/secrets/%242a%2410%24TuW1sqhflBosebCE5KLXZ.OLNpc5inG07uPLgdzCzucFMsttfei4."
    }
]
}`

then go to the link:

`GET /secrets/%242a%2410%24TuW1sqhflBosebCE5KLXZ.OLNpc5inG07uPLgdzCzucFMsttfei4.`

and result will be the same secret that user created in the first requrest.

Please note that secret is stored as encrypted text with pass and salt passed to the encoder as an app properties.
In prod environment it should be stored in the vault or in the environment variables.
