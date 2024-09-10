package com.employee.details.controller;

import com.employee.details.model.*;
import com.employee.details.service.EmployeeService;

import javax.ejb.EJB;

import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/emp")
public class EmployeeController {

  @EJB
   private EmployeeService employeeService;

    @GET
    @Path("/getallemp")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEmployees() {

        return Response.ok(employeeService.getAllEmployees()).build();
    }

        @GET
        @Path("/{id}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response getEmployee(@PathParam("id") int id) {
            Employee employee = employeeService.getEmployeeById(id);
            if (employee == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            return Response.ok(employee).build();
        }


        @POST
        @Path("/create")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public Response createEmployee(Employee employee) {
            Employee createdEmployee = employeeService.createEmployee(employee);
            return Response.status(Response.Status.CREATED).entity(createdEmployee).build();
        }


        @PUT
        @Path("/{id}")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public Response updateEmployee(@PathParam("id") int id, Employee employee) {
            Employee updatedEmployee = employeeService.updateEmployee(id, employee);
            if (updatedEmployee == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            return Response.ok(updatedEmployee).build();
        }


        @DELETE
        @Path("/{id}")
        public Response deleteEmployee(@PathParam("id") int id) {
            boolean isDeleted = employeeService.deleteEmployee(id);
            if (!isDeleted) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            return Response.noContent().build();
        }

        // Fetch all addresses
//        @GET
//        @Path("/addresses")
//        @Produces(MediaType.APPLICATION_JSON)
//        public Response getAllAddresses() {
//            List<Address> addressList = employeeService.getAllAddresses();
//            return Response.ok(addressList).build();
//        }
//
//        // Fetch a specific address by ID
//        @GET
//        @Path("/addresses/{id}")
//        @Produces(MediaType.APPLICATION_JSON)
//        public Response getAddress(@PathParam("id") int id) {
//            Address address = employeeService.getAddressById(id);
//            if (address == null) {
//                return Response.status(Response.Status.NOT_FOUND).build();
//            }
//            return Response.ok(address).build();
//        }
//
//        // Create a new address
//        @POST
//        @Path("/addresses")
//        @Consumes(MediaType.APPLICATION_JSON)
//        @Produces(MediaType.APPLICATION_JSON)
//        public Response createAddress(Address address) {
//            Address createdAddress = employeeService.createAddress(address);
//            return Response.status(Response.Status.CREATED).entity(createdAddress).build();
//        }
//
//        // Update an existing address
//        @PUT
//        @Path("/addresses/{id}")
//        @Consumes(MediaType.APPLICATION_JSON)
//        @Produces(MediaType.APPLICATION_JSON)
//        public Response updateAddress(@PathParam("id") int id, Address address) {
//            Address updatedAddress = employeeService.updateAddress(id, address);
//            if (updatedAddress == null) {
//                return Response.status(Response.Status.NOT_FOUND).build();
//            }
//            return Response.ok(updatedAddress).build();
//        }
//
//        // Delete an address by ID
//        @DELETE
//        @Path("/addresses/{id}")
//        public Response deleteAddress(@PathParam("id") int id) {
//            boolean isDeleted = employeeService.deleteAddress(id);
//            if (!isDeleted) {
//                return Response.status(Response.Status.NOT_FOUND).build();
//            }
//            return Response.noContent().build();
//        }
    }








    //-----------------------------------------------------------------------------------------

//    public Response getAllEmployees() {
//       List<Employee> employeeList= employeeService.getAllEmployees();
//       return Response.ok(employeeList).build();
//       //return Response.ok("employeeList").build();
//
//    }

//    @GET
//    @Path("/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getEmployee(@PathParam("id") int id) {
//        EntityManager em = emf.createEntityManager();
//        try {
//            Employee employee = em.find(Employee.class, id);
//            if (employee == null) {
//                return Response.status(Response.Status.NOT_FOUND).build();
//            }
//            return Response.ok(employee).build();
//        } finally {
//            em.close();
//        }
//    }
//
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response createEmployee(Employee employee) {
//        EntityManager em = emf.createEntityManager();
//        try {
//            em.getTransaction().begin();
//            em.persist(employee);
//            em.getTransaction().commit();
//            return Response.status(Response.Status.CREATED).entity(employee).build();
//        } finally {
//            em.close();
//        }
//    }
//
//    @PUT
//    @Path("/{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response updateEmployee(@PathParam("id") int id, Employee employee) {
//        EntityManager em = emf.createEntityManager();
//        try {
//            Employee existingEmployee = em.find(Employee.class, id);
//            if (existingEmployee == null) {
//                return Response.status(Response.Status.NOT_FOUND).build();
//            }
//            em.getTransaction().begin();
//            existingEmployee.setEmpName(employee.getEmpName());
//            existingEmployee.setEmpCompanyName(employee.getEmpCompanyName());
//            existingEmployee.setEmpBloodGroup(employee.getEmpBloodGroup());
//            existingEmployee.setGCMLevel(employee.getGCMLevel());
//            existingEmployee.setDassId(employee.getDassId());
//            existingEmployee.setAddress(employee.getAddress());
//            // Here, based on the instance type (Manager, ConsultantDelivery, etc.), we can set additional fields
//            if (employee instanceof Manager) {
//                ((Manager) existingEmployee).setTeamSize(((Manager) employee).getTeamSize());
//                ((Manager) existingEmployee).setLocation(((Manager) employee).getLocation());
//            } else if (employee instanceof ConsultantDelivery) {
//                ((ConsultantDelivery) existingEmployee).setConsultingLevel(((ConsultantDelivery) employee).getConsultingLevel());
//                ((ConsultantDelivery) existingEmployee).setLeadProjects(((ConsultantDelivery) employee).getLeadProjects());
//            } else if (employee instanceof AssociateConsultantDelivery) {
//                ((AssociateConsultantDelivery) existingEmployee).setSkillSet(((AssociateConsultantDelivery) employee).getSkillSet());
//                ((AssociateConsultantDelivery) existingEmployee).setProjectRole(((AssociateConsultantDelivery) employee).getProjectRole());
//                ((AssociateConsultantDelivery) existingEmployee).setReportsTo(((AssociateConsultantDelivery) employee).getReportsTo());
//            }
//            em.getTransaction().commit();
//            return Response.ok(existingEmployee).build();
//        } finally {
//            em.close();
//        }
//    }
//
//    @DELETE
//    @Path("/{id}")
//    public Response deleteEmployee(@PathParam("id") int id) {
//        EntityManager em = emf.createEntityManager();
//        try {
//            Employee employee = em.find(Employee.class, id);
//            if (employee == null) {
//                return Response.status(Response.Status.NOT_FOUND).build();
//            }
//            em.getTransaction().begin();
//            em.remove(employee);
//            em.getTransaction().commit();
//            return Response.noContent().build();
//        } finally {
//            em.close();
//        }
//    }
//
//    // CRUD operations for Address remain the same
//    @GET
//    @Path("/addresses")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getAllAddresses() {
//        EntityManager em = emf.createEntityManager();
//        try {
//            TypedQuery<Address> query = em.createQuery("SELECT a FROM Address a", Address.class);
//            List<Address> addresses = query.getResultList();
//            return Response.ok(addresses).build();
//        } finally {
//            em.close();
//        }
//    }
//
//    @GET
//    @Path("/addresses/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getAddress(@PathParam("id") int id) {
//        EntityManager em = emf.createEntityManager();
//        try {
//            Address address = em.find(Address.class, id);
//            if (address == null) {
//                return Response.status(Response.Status.NOT_FOUND).build();
//            }
//            return Response.ok(address).build();
//        } finally {
//            em.close();
//        }
//    }
//
//    @POST
//    @Path("/addresses")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response createAddress(Address address) {
//        EntityManager em = emf.createEntityManager();
//        try {
//            em.getTransaction().begin();
//            em.persist(address);
//            em.getTransaction().commit();
//            return Response.status(Response.Status.CREATED).entity(address).build();
//        } finally {
//            em.close();
//        }
//    }
//
//    @PUT
//    @Path("/addresses/{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response updateAddress(@PathParam("id") int id, Address address) {
//        EntityManager em = emf.createEntityManager();
//        try {
//            Address existingAddress = em.find(Address.class, id);
//            if (existingAddress == null) {
//                return Response.status(Response.Status.NOT_FOUND).build();
//            }
//            em.getTransaction().begin();
//            existingAddress.setBuildingName(address.getBuildingName());
//            existingAddress.setCity(address.getCity());
//            existingAddress.setPinCode(address.getPinCode());
//            existingAddress.setMobNo(address.getMobNo());
//            em.getTransaction().commit();
//            return Response.ok(existingAddress).build();
//        } finally {
//            em.close();
//        }
//    }
//
//    @DELETE
//    @Path("/addresses/{id}")
//    public Response deleteAddress(@PathParam("id") int id) {
//        EntityManager em = emf.createEntityManager();
//        try {
//            Address address = em.find(Address.class, id);
//            if (address == null) {
//                return Response.status(Response.Status.NOT_FOUND).build();
//            }
//            em.getTransaction().begin();
//            em.remove(address);
//            em.getTransaction().commit();
//            return Response.noContent().build();
//        } finally {
//            em.close();
//        }
//    }

