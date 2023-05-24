//package com.firstRESTapiAPP.firtstRESTapi.Controllers;
//
//
//import com.firstRESTapiAPP.firtstRESTapi.dto.PersonDTO;
//import com.firstRESTapiAPP.firtstRESTapi.models.Person;
//import com.firstRESTapiAPP.firtstRESTapi.services.PeopleService;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//
//@RequestMapping("/ppl")
//@RestController
//public class PeopleController {
//private  final  PeopleService peopleService;
//private final ModelMapper modelMapper;
//    @Autowired
//    public PeopleController(PeopleService peopleService,
//                            ModelMapper modelMapper) {
//        this.peopleService = peopleService;
//        this.modelMapper = modelMapper;
//    }
//
//
//    @GetMapping()
//    public List<PersonDTO> getPeople(){
//        return  peopleService.findAll().stream().map(this::converToPersonDTO)
//                .collect(Collectors.toList());
//    }
//
//    @GetMapping("/{id}")
//    public  PersonDTO getPerson(@PathVariable(value = "id",required = true) int id){
//        return converToPersonDTO(peopleService.findOne(id));
//    }
//
//    @PostMapping()
//    public ResponseEntity<HttpStatus> createPerson(@RequestBody PersonDTO personDTO, BindingResult bindingResult){
//        if(bindingResult.hasErrors()){
//            StringBuilder errorMsg = new StringBuilder();
//
//           List<FieldError> errors =   bindingResult.getFieldErrors();
//           for(FieldError error : errors){
//               errorMsg.append(error.getField())
//                       .append(" - ").append(error.getDefaultMessage())
//                       .append(";");
//           }
//           throw new PersonNotCreatedException(errorMsg.toString());
//        }
//
//        peopleService.save(convertToPerson(personDTO));
//        return  ResponseEntity.ok(HttpStatus.OK);
//    }
//
//    @ExceptionHandler
//    private ResponseEntity<PersonErrorResponse> handleException(PersonNotFoundException e){
//        PersonErrorResponse response = new PersonErrorResponse(
//                "Person with this id wasnt found",System.currentTimeMillis()
//        );
//
//        return  new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler
//    private ResponseEntity<PersonErrorResponse> handleException(PersonNotCreatedException e){
//        PersonErrorResponse response = new PersonErrorResponse(
//                e.getMessage(),System.currentTimeMillis()
//        );
//
//        return  new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }
//
//    private Person convertToPerson(PersonDTO personDTO) {
//        return   modelMapper.map(personDTO, Person.class);
//    }
//
//    private PersonDTO converToPersonDTO (Person person){
//        return modelMapper.map(person, PersonDTO.class);
//    }
//
//}
