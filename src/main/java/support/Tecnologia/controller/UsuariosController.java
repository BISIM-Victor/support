package support.Tecnologia.controller;

import io.swagger.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import support.Tecnologia.dto.Response.ResponseDTO;
import support.Tecnologia.entity.Usuarios;
import support.Tecnologia.service.UsuariosService;

@Api(tags = "API de Usuarios")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    private static final Logger logger = LogManager.getLogger(UsuariosController.class);

    @Autowired
    private UsuariosService usuariosService;

    // ✅ PRUEBA SI EL SERVIDOR ESTÁ FUNCIONANDO
    @GetMapping("/home")
    public String home() {
        return "¡La aplicación está corriendo!";
    }

    // ✅ CREAR UN NUEVO USUARIO
    @ApiOperation(value = "Crear un nuevo usuario", response = ResponseDTO.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Usuario creado correctamente"),
            @ApiResponse(code = 400, message = "Error al crear usuario")
    })
    @PostMapping("/crear")
    public ResponseEntity<ResponseDTO> createUsuarios(@RequestBody Usuarios usuarios) {
        try {
            logger.info("Intentando crear usuario: " + usuarios.getUsuario());
            return ResponseEntity.ok(usuariosService.createUsuarios(usuarios));
        } catch (Exception e) {
            logger.error("Error al crear usuario: " + e.getMessage());
            return ResponseEntity.badRequest().body(new ResponseDTO("Error al crear usuario", false));
        }
    }

    // ✅ OBTENER TODOS LOS USUARIOS
    @ApiOperation(value = "Obtener todos los usuarios", response = ResponseDTO.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Usuarios encontrados"),
            @ApiResponse(code = 500, message = "Error interno del servidor")
    })
    @GetMapping
    public ResponseEntity<ResponseDTO> getAllUsuarios() {
        try {
            return ResponseEntity.ok(usuariosService.getAllUsuarios());
        } catch (Exception e) {
            logger.error("Error al obtener usuarios: " + e.getMessage());
            return ResponseEntity.internalServerError().body(new ResponseDTO("Error interno", false));
        }
    }

    // ✅ OBTENER UN USUARIO POR ID
    @ApiOperation(value = "Obtener un usuario por ID", notes = "Devuelve los detalles de un usuario por su ID", response = ResponseDTO.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Usuario encontrado"),
            @ApiResponse(code = 404, message = "Usuario no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getUsuarios(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(usuariosService.getUsuarios(id));
        } catch (Exception e) {
            logger.error("Usuario no encontrado: " + e.getMessage());
            return ResponseEntity.status(404).body(new ResponseDTO("Usuario no encontrado", false));
        }
    }

    // ✅ ELIMINAR UN USUARIO (BORRADO LÓGICO)
    @ApiOperation(value = "Eliminar un usuario por ID", notes = "Realiza un borrado lógico del usuario", response = ResponseDTO.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Usuario eliminado"),
            @ApiResponse(code = 404, message = "Usuario no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteUsuarios(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(usuariosService.deleteUsuarios(id));
        } catch (Exception e) {
            logger.error("Error al eliminar usuario: " + e.getMessage());
            return ResponseEntity.status(404).body(new ResponseDTO("Usuario no encontrado", false));
        }
    }
}
