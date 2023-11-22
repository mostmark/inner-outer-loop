package com.redhat.cloudnative;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/inventory")
@ApplicationScoped
public class InventoryResource {

    @Inject
    EntityManager em;

    @GET
    @Path("/{itemId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Counted(value = "inventory_coolstore", description = "Number of times the inventory service has been invoked")
    @Timed(value = "inventory_coolstore", description = "How long it takes to retrieve the inventory value")
    public Inventory getAvailability(@PathParam("itemId") String itemId) {
        Inventory inventory = em.find(Inventory.class, itemId);
        return inventory;
    }
}
