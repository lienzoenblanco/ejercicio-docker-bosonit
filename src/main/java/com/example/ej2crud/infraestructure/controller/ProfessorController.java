package com.example.ej2crud.infraestructure.controller;

import com.example.ej2crud.application.*;
import com.example.ej2crud.application.dto.ResponseDto;
import com.example.ej2crud.infraestructure.dto.input.InputProfessorDto;
import com.example.ej2crud.infraestructure.dto.output.OutputProfessorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private AddProfessorUseCase addProfessorUseCase;
    @PostMapping
    public ResponseEntity add(@RequestBody InputProfessorDto inputProfessorDto){
        ResponseDto responseDto = this.addProfessorUseCase.add(inputProfessorDto);
        if (!responseDto.getSuccess()){
            return new ResponseEntity(responseDto, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(responseDto, HttpStatus.CREATED);
    }

    @Autowired
    private ListProfessorUseCase listProfessorUseCase;
    @GetMapping
    public List<OutputProfessorDto> list(){
        return this.listProfessorUseCase.list();
    }

    @Autowired
    private ByIdProfessorUseCase byIdProfessorUseCase;
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable int id) {
        return new ResponseEntity<>(this.byIdProfessorUseCase.getById(id), HttpStatus.OK);
    }

    @Autowired
    private UpdateProfessorUseCase updateProfessorUseCase;
    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody InputProfessorDto professor,
                                 @PathVariable int id
    ) {
        return new ResponseEntity<>(this.updateProfessorUseCase.update(professor, id), HttpStatus.ACCEPTED);
    }

    @Autowired
    private DeleteProfessorUseCase deleteProfessorUseCase;
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.deleteProfessorUseCase.delete(id);
    }
}
