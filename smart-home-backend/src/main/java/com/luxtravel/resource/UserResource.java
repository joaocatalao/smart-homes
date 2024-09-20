package com.example.resource;

import com.example.entity.User;
import io.smallrye.jwt.build.Jwt;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Arrays;
import jakarta.annotation.security.RolesAllowed;


@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @POST
    @Path("/register")
    @Transactional
    public Response registerUser(User user) {
        if (User.find("username", user.username).firstResult() != null) {
            return Response.status(Response.Status.CONFLICT).entity("Username already exists").build();
        }
        user.persist();
        return Response.status(Response.Status.CREATED).build();
    }

    @POST
    @Path("/login")
    public Response loginUser(User user) {
        User foundUser = User.find("username", user.username).firstResult();

        // Check if user was found
        if (foundUser == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("User not found").build();
        }

        // Verify password
        if (!foundUser.password.equals(user.password)) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid credentials").build();
        }

        // Create JWT token using foundUser
        String token = Jwt.issuer("smart-home-backend")
                        .upn(foundUser.username)
                        .groups(new HashSet<>(Arrays.asList("User")))
                        .sign();

        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return Response.ok(response).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteUser(@PathParam("id") Long id) {
        User user = User.findById(id);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("User not found").build();
        }

        user.delete();
        return Response.noContent().build(); // 204 No Content
    }

}
