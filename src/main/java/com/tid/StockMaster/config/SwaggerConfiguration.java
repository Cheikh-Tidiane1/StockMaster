package com.tid.StockMaster.config;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                description = "Gestion de stock API documentation",
                title = "Gestion de stock REST API",
                version = "1.0"

        ),
        servers = @Server(
                description = "local dev",
                url = "http://localhost:9001"
        )
)
public class SwaggerConfiguration {

}
