package TI.support.controller;

import TI.support.dto.ResponseDTO;
import TI.support.entity.Perfiles;
import TI.support.service.PerfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/perfiles")
public class PerfilesController {

    @Autowired
    private PerfilesService perfilesService;

    @PostMapping("/crear")
    public ResponseEntity<ResponseDTO> createPerfiles(@RequestBody Perfiles perfiles) {
        return ResponseEntity.ok(perfilesService.createPerfiles(perfiles));
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> getAllPerfiles() {
        return ResponseEntity.ok(perfilesService.getAllPerfiles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getPerfiles(@PathVariable Long id) {
        return ResponseEntity.ok(perfilesService.getPerfiles(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deletePerfiles(@PathVariable Long id) {
        return ResponseEntity.ok(perfilesService.deletePerfiles(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> updatePerfiles(@PathVariable Long id, @RequestBody Perfiles perfiles) {
        return ResponseEntity.ok(perfilesService.updatePerfiles(perfiles));
    }




}
