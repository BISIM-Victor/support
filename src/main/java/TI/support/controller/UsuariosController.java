package TI.support.controller;


import TI.support.dto.ResponseDTO;
import TI.support.entity.Usuarios;
import TI.support.service.UsuariosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "API de Usuarios ")


@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @GetMapping("/home")
    public String home() {
        logger.info("Accedió a la ruta /usuarios/home");
        return "¡La aplicación está corriendo!";
    }
    private static final Logger logger = LogManager.getLogger(UsuariosService.class);

    @Autowired
    UsuariosService usuariosService;

    // Crear un nuevo usuario
    @ApiOperation(value = "Crear un nuevo usuario", response = ResponseDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuario creado correctamente"),
            @ApiResponse(code = 400, message = "Error al crear usuario")
    })
    @PostMapping("/crear")
    public ResponseEntity<ResponseDTO> createUsuarios(@RequestBody Usuarios usuarios) {
        return ResponseEntity.ok(usuariosService.createUsuarios(usuarios));
    }


    // Obtener todos los usuarios
    @ApiOperation(value = "Obtener todos los usuarios", notes = "Devuelve una lista de todos los usuarios", response = ResponseDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuarios encontrados"),
            @ApiResponse(code = 500, message = "Error interno del servidor")
    })
    @GetMapping
    public ResponseEntity<ResponseDTO> getAllUsuarios() {
        return ResponseEntity.ok(usuariosService.getAllUsuarios());
    }


    // Obtener un usuario por ID
    @ApiOperation(value = "Obtener un usuario por ID", notes = "Devuelve los detalles de un usuario por su ID", response = ResponseDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuario encontrado"),
            @ApiResponse(code = 404, message = "Usuario no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getUsuarios(@PathVariable Long id) {
        return ResponseEntity.ok(usuariosService.getUsuarios(id));
    }


    // Eliminar un usuario (borrado lógico)
    @ApiOperation(value = "Eliminar un usuario por ID", notes = "Realiza un borrado lógico del usuario", response = ResponseDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuario eliminado"),
            @ApiResponse(code = 404, message = "Usuario no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteUsuarios(@PathVariable Long id) {
        return ResponseEntity.ok(usuariosService.deleteUsuarios(id));
    }
}
