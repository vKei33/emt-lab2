package emt.lab.Library.service.impl;

import emt.lab.Library.dao.CountryDao;
import emt.lab.Library.model.Country;
import emt.lab.Library.model.exceptions.InvalidCountryIdException;
import emt.lab.Library.service.CountryService;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryDao countryDao;

    public CountryServiceImpl(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @Override
    public Country getById(Long id) {
        return this.countryDao.findById(id).orElseThrow(InvalidCountryIdException::new);
    }
}
