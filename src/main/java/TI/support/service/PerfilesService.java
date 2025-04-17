package TI.support.service;

import TI.support.Enums.MessageEnum;
import TI.support.dto.ResponseDTO;
import TI.support.entity.Perfiles;
import TI.support.repository.PerfilesRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilesService {

    @Autowired
    private PerfilesRespository perfilesRespository;

    public ResponseDTO createPerfiles(Perfiles perfiles) {
        ResponseDTO response = new ResponseDTO();

        try {
            perfilesRespository.save(perfiles);
            response.setMsg(MessageEnum.OK.getMessage());
            response.setBody(perfiles);
        } catch (Exception e) {
            response.setMsg(MessageEnum.ERROR.getMessage());
            response.setBody(null);
        }

        return response;
    }

    public ResponseDTO getAllPerfiles() {
        ResponseDTO response = new ResponseDTO();

        try {
            List<Perfiles> perfiles = perfilesRespository.findAll();
            response.setMsg(MessageEnum.OK.getMessage());
            response.setBody(perfiles);
        } catch (Exception e) {
            response.setMsg(MessageEnum.ERROR.getMessage());
            response.setBody(null);
        }

        return response;
    }

    public ResponseDTO getPerfiles(Long id) {
        ResponseDTO response = new ResponseDTO();
        try {
            Perfiles perfiles = perfilesRespository.findById(id).get();
            response.setMsg(MessageEnum.OK.getMessage());
            response.setBody(perfiles);
        } catch (Exception e) {
            response.setMsg(MessageEnum.ERROR.getMessage());
            response.setBody(null);
        }

        return response;
    }

    public ResponseDTO deletePerfiles(Long id) {
        ResponseDTO response = new ResponseDTO();

        try {
            Perfiles perfiles = perfilesRespository.findById(id).get();
            perfiles.setEstatus(0);
            perfilesRespository.save(perfiles);
            response.setMsg(MessageEnum.OK.getMessage());
            response.setBody(perfiles);
        } catch (Exception e) {
            response.setMsg(MessageEnum.ERROR.getMessage());
            response.setBody(null);
        }

        return response;
    }

    public ResponseDTO updatePerfiles(Perfiles perfiles) {
        ResponseDTO response = new ResponseDTO();

        try {
            perfilesRespository.save(perfiles);
            response.setMsg(MessageEnum.OK.getMessage());
            response.setBody(perfiles);
        } catch (Exception e) {
            response.setMsg(MessageEnum.ERROR.getMessage());
            response.setBody(null);
        }

        return response;
    }


}
