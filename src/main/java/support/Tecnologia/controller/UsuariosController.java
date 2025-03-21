package support.Tecnologia.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import support.Tecnologia.dto.Response.ResponseDTO;
import support.Tecnologia.entity.Usuarios;
import support.Tecnologia.service.UsuariosService;


@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    private static final Logger logger = LogManager.getLogger(UsuariosService.class);

    @Autowired
    UsuariosService usuariosService;

    @PostMapping("/crear")
    public ResponseEntity<ResponseDTO> createUsuarios(@RequestBody Usuarios usuarios) {
        return ResponseEntity.ok(usuariosService.createUsuarios(usuarios));
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> getAllUsuarios() {
        return ResponseEntity.ok(usuariosService.getAllUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getUsuarios(@PathVariable Long id) {
        return ResponseEntity.ok(usuariosService.getUsuarios(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteUsuarios(@PathVariable Long id) {
        return ResponseEntity.ok(usuariosService.deleteUsuarios(id));
    }
}
