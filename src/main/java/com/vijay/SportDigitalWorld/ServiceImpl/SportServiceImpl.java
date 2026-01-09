package com.vijay.SportDigitalWorld.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.SportDigitalWorld.Config.RestClientConfig;
import com.vijay.SportDigitalWorld.Dto.SportsApiResponse;
import com.vijay.SportDigitalWorld.Dto.SportsData;
import com.vijay.SportDigitalWorld.Entity.Sport;
import com.vijay.SportDigitalWorld.Repository.SportRepository;
import com.vijay.SportDigitalWorld.Service.SportService;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class SportServiceImpl implements SportService{
	
	
	private final String SportAPI_URL = "https://stapubox.com/sportslist/";
	
	@Autowired
	private SportRepository sportRepository;
	
	@Autowired
	private RestClientConfig restClient;

	@Override
	public void loadSportFromApi() {
		// TODO Auto-generated method stub
		
		SportsApiResponse res = restClient.restClient().get().uri(SportAPI_URL).retrieve().body(SportsApiResponse.class);
		
		if(res == null || res.getData() == null) {
			System.out.println("No response from the external Sport API");
			return;
		}else {
			for(SportsData sport : res.getData()) {
				boolean exist = sportRepository.findBySportCode(sport.getSportsCode()).isPresent();
				
				if(exist) {
					continue;
				}else {
					Sport s = new Sport();
					s.setSportCode(sport.getSportsCode());
					s.setSportId(sport.getSportsId());
					s.setSportName(sport.getSportsName());
					
					sportRepository.save(s);
				}
			}
			
			System.out.println("All sports loaded Successfully from API");
		}
		
		
	}

	
}
