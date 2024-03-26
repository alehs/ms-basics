## General

Since task description was super unclear, I decided to implement the following:

- jmp-dto: DTOs for the API
- jmp-service-api: API definition (Controllers, Delegates, Service interfaces)
- jmp-service-rest: Implementation of the Controller's delegates and also Controllers for the RMM level 0-3 API.
- jmp-cloud-service-impl: Implementation of the Service interfaces, Converters and SpringBoot starters class.


## Richardson Maturity Model

I implemented all 3 RMM levels.
Implementations are available in the jmp-service-rest (packages v0-v2)
Please note that v2 and v3 share the same package because HATEOAS support was added as a spring lib

## API-first approach:
API for RMM level 2-3 I implemented using the API-first approach.
   1. I have created a [swagger.yaml](/api-spec/rest-api.yaml) file with the API definition.
   2. I have used [swagger-codegen] to generate DTOs into jmp-dto module and API into jmp-service-api module.
   3. I have used delegate pattern to implement the API in jmp-service-rest module.
   4. Unfortunately swagger doesn't support OpenAPI 3.0 spec where HATEOAS is supported as part of the spec, so I had to use OpenAPI(swagger) 2.0 spec and map links manually  
