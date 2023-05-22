package com.taffah.springjwt.controllers;

import com.taffah.springjwt.dtos.AeroportDTO;
import com.taffah.springjwt.exceptions.ProductNotFoundException;
import com.taffah.springjwt.services.AeroportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
  @Autowired
  private AeroportService aeroportService;

  @GetMapping("/all")
  public String allAccess() {
    return "Public Content.";
  }

  @GetMapping("/ROLE_CLIENT")
  @PreAuthorize("hasRole('USER') or hasRole('ROLE_CLIENT ') or hasRole('ADMIN')")
  public String userAccess() {
    return "User Content.";
  }

  @GetMapping("/ROLE_AEROPORT ")
  @PreAuthorize("hasRole('ROLE_AEROPORT ')")
  public String moderatorAccess() {
    return "Moderator Board.";
  }

  // Admin authorizations

  @GetMapping("/admin/aeroports")
  @PreAuthorize("hasRole('ADMIN')")
  public Page<AeroportDTO> getAeroports(
          @RequestParam(defaultValue = "1") int page,
          @RequestParam(defaultValue = "4") int size
  ) {
    Pageable pageable = PageRequest.of(page - 1, size);
    return aeroportService.getAeroports(pageable);
  }


  @PostMapping("/admin/aeroports")
  @PreAuthorize("hasRole('ADMIN')")
  public AeroportDTO saveAeroport(@RequestBody AeroportDTO AeroportDTO) {
    return aeroportService.saveAeroport(AeroportDTO);
  }

  @DeleteMapping("/admin/aeroports/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public void deleteAeroport(@PathVariable("id") Long id) throws ProductNotFoundException {
    aeroportService.deleteAeroport(id);
  }

  @GetMapping("/admin/aeroports/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public AeroportDTO getAeroport(@PathVariable("id") Long id) throws ProductNotFoundException {
    return aeroportService.getAeroportById(id);
  }

  @PutMapping("/admin/aeroports/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public AeroportDTO updateAeroport(@PathVariable("id") Long id, @RequestBody AeroportDTO updatedAeroportDTO) throws ProductNotFoundException {
    return aeroportService.updateAeroport(id, updatedAeroportDTO);
  }

  @GetMapping("/admin/aeroports/search")
  @PreAuthorize("hasRole('ADMIN')")
  public List<AeroportDTO> searchByKeyword(@RequestParam("keyword") String keyword) {
    return aeroportService.getAeroportsByKeyword(keyword);
  }
}
