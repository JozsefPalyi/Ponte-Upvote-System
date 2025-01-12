package hu.ponte.upvote_project.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STANDARD);


//        modelMapper.addMappings(new PropertyMap<Reservation, BookingDetails>() {
//            protected void configure() {
//                map(source.getRoom().getHotel().getName(), destination.getHotelName());
//                map(source.getRoom().getId(), destination.getRoomId());
//                using(ctx -> ctx.getSource().toString()).map(source.getStartDate(), destination.getStartDate());
//                using(ctx -> ctx.getSource().toString()).map(source.getEndDate(), destination.getEndDate());
//            }
//        });
        return modelMapper;
    }
}
