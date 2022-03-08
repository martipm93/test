package com.slashmobility.test.web.endpoint;

import com.slashmobility.test.service.CompanyService;
import com.slashmobility.test.web.dto.CompanyDTO;
import com.slashmobility.test.web.endpoint.constants.URLConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = URLConstants.COMPANY_ROOT)
public class CompanyEndpoint {

    private final CompanyService companyService;

    public CompanyEndpoint(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public List<CompanyDTO> getAllCompanies() {
        return companyService.findAll();
    }

    @GetMapping(value = URLConstants.ID_PATH_PARAM, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public CompanyDTO getCompany(@PathVariable(URLConstants.ID_PARAM) Long id) {
        return companyService.findById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public CompanyDTO createCompany(@RequestBody CompanyDTO companyDTO) {
        return companyService.create(companyDTO);
    }

    @PutMapping(value = URLConstants.ID_PATH_PARAM, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public CompanyDTO updateCompany(@PathVariable(URLConstants.ID_PARAM) Long id,
                                    @RequestBody CompanyDTO companyDTO) {
        return companyService.update(companyDTO, id);
    }
}
