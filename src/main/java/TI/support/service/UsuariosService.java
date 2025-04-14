package TI.support.service;


import TI.support.Enums.MessageEnum;
import TI.support.dto.ResponseDTO;
import TI.support.entity.Usuarios;
import TI.support.repository.UsuariosRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {
    private static final Logger logger = LogManager.getLogger(UsuariosService.class);


    @Autowired
    private UsuariosRepository usuariosRepository;


    // Método para crear un usuario
    public ResponseDTO createUsuarios(Usuarios usuario) {
        ResponseDTO response = new ResponseDTO();

        try {
            // Guardamos el usuario en la base de datos
            Usuarios usuarios = usuariosRepository.save(usuario);

            // Registramos el evento de creación del usuario en los logs
            logger.info("Usuario creado: {}", usuarios);

            // Preparamos la respuesta con mensaje de éxito y el objeto de usuario creado
            response.setMsg(MessageEnum.OK.getMessage());
            response.setBody(usuarios);
        } catch (Exception e) {
            // Si ocurre algún error, registramos el mensaje de error
            response.setMsg(MessageEnum.ERROR.getMessage());
            response.setBody(null);
        }
        return response;
    }

    // Método para obtener todos los usuarios
    public ResponseDTO getAllUsuarios() {
        ResponseDTO response = new ResponseDTO();

        try {
            // Obtenemos todos los usuarios de la base de datos
            List<Usuarios> usuarios = usuariosRepository.findAll();

            // Registramos los usuarios encontrados en los logs
            logger.info("Usuarios encontrados: {}", usuarios);

            // Preparamos la respuesta con mensaje de éxito y la lista de usuarios
            response.setMsg(MessageEnum.OK.getMessage());
            response.setBody(usuarios);
        } catch (Exception e) {
            // Si ocurre algún error, lo registramos y enviamos una respuesta de error
            logger.error("Error al obtener los usuarios", e);
            response.setMsg(MessageEnum.ERROR.getMessage());
            response.setBody(null);
        }

        return response;
    }


    // Método para obtener un usuario por su ID
    public ResponseDTO getUsuarios(Long id) {
        ResponseDTO response = new ResponseDTO();
        try {
            // Intentamos buscar el usuario por su ID
            Optional<Usuarios> usuarios = usuariosRepository.findById(id);

            if (usuarios.isPresent()) {
                // Si el usuario fue encontrado, lo registramos en los logs y devolvemos la información
                logger.info("Usuario encontrado: {}", usuarios.get());
                response.setMsg(MessageEnum.OK.getMessage());
                response.setBody(usuarios.get()); // Extraemos el objeto de Optional y lo ponemos en el cuerpo de la respuesta
            } else {
                // Si no se encuentra el usuario, devolvemos un mensaje indicando que no se encontró
                response.setMsg(MessageEnum.NOT_FOUND.getMessage());
                response.setBody(null); // Cuerpo de la respuesta vacío, ya que no se encontró el usuario
            }

        } catch (Exception e) {
            // Si ocurre un error durante la ejecución, lo capturamos y devolvemos un mensaje de error
            response.setMsg(MessageEnum.ERROR.getMessage());
            response.setBody(null);
        }
        return response;
    }


    // delete users
    public ResponseDTO deleteUsuarios(Long id) {
        ResponseDTO response = new ResponseDTO();
        try {
            // Buscar el usuario por ID
            Optional<Usuarios> usuarios = usuariosRepository.findById(id);

            if (usuarios.isPresent()) {
                Usuarios usuario = usuarios.get();

                // Verificamos si el usuario ya está eliminado
                if (usuario.getEstatus() != 0) {
                    // Realizamos el borrado lógico
                    usuario.setEstatus(0);  // Marcamos como eliminado (estatus 0)
                    usuariosRepository.save(usuario);  // Guardamos los cambios
                    response.setMsg(MessageEnum.OK.getMessage());
                } else {
                    // Si el usuario ya está eliminado, podemos enviar un mensaje apropiado
                    response.setMsg("El usuario ya está eliminado");
                }

            } else {
                // Si no encontramos el usuario, devolver un mensaje
                response.setMsg("Usuario no encontrado");
            }
            response.setBody(null);

        } catch (Exception e) {
            // En caso de error, capturamos la excepción y la logueamos
            e.printStackTrace(); // Puedes usar un logger aquí para más detalles
            response.setMsg(MessageEnum.ERROR.getMessage());
            response.setBody(null);
        }
        return response;
    }

}
