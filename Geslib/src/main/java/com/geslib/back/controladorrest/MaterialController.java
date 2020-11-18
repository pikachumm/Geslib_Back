package com.geslib.back.controladorrest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geslib.back.modelo.Material;
import com.geslib.back.servicio.MaterialService;

@RestController
@RequestMapping("/materiales")
public class MaterialController {
	@Autowired
	MaterialService materialService;
	
    @GetMapping("/listarMateriales")
    public ResponseEntity<List<Material>> list(){
        List<Material> list = materialService.listarPeliculas();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<?> create(@RequestBody Material material){
     materialService.add(material);
     return new ResponseEntity(HttpStatus.OK);
    }


}
