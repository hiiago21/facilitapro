package br.com.facilitapro.api.user;

import br.com.facilitapro.api.user.dto.UserDTO;
import br.com.facilitapro.api.user.mappers.UserMapperApi;
import br.com.facilitapro.business.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = UserRest.BASE_URL)
public class UserRest {
    public static final String BASE_URL = "/facilitapro/v1/user";

    private final UserService service;
    private final UserMapperApi mapper;

    @PostMapping
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.userBoToDto(service.save(mapper.userDtoToBo(dto))));
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<UserDTO> find(@PathVariable String uuid) {
        return ResponseEntity.status(HttpStatus.OK).body(mapper.userBoToDto(service.find(uuid)));
    }

}
