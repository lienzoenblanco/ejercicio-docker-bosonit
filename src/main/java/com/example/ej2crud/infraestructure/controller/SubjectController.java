package com.example.ej2crud.infraestructure.controller;

import com.example.ej2crud.application.dto.ResponseDto;
import com.example.ej2crud.application.subject.AddSubjectUseCase;
import com.example.ej2crud.application.subject.ByIdSubjectUseCase;
import com.example.ej2crud.application.subject.DeleteSubjectUseCase;
import com.example.ej2crud.application.subject.UpdateSubjectUseCase;
import com.example.ej2crud.infraestructure.dto.input.InputSubjectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private AddSubjectUseCase addSubjectUseCase;
    @PostMapping
    public ResponseEntity add(@RequestBody InputSubjectDto inputSubjectDto){
        ResponseDto responseDto = this.addSubjectUseCase.add(inputSubjectDto);
        if (!responseDto.getSuccess()){
            return new ResponseEntity(responseDto, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(responseDto, HttpStatus.CREATED);
    }

    @Autowired
    private ByIdSubjectUseCase byIdSubjectUseCase;
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable int id){
        return new ResponseEntity<>(this.byIdSubjectUseCase.getById(id), HttpStatus.OK);
    }

    @Autowired
    private UpdateSubjectUseCase updateSubjectUseCase;
    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody InputSubjectDto subject,
                                 @PathVariable int id
    ) {
        return new ResponseEntity(this.updateSubjectUseCase.update(subject, id), HttpStatus.ACCEPTED);
    }

    @Autowired
    private DeleteSubjectUseCase deleteSubjectUseCase;
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.deleteSubjectUseCase.delete(id);
    }
}
