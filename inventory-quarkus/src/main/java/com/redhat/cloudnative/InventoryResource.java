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
    @Counted
    @Timed
    public Inventory getAvailability(@PathParam("itemId") String itemId) {
        Inventory inventory = em.find(Inventory.class, itemId);
        return inventory;
    }
}
