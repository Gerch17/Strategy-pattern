package ru.team1419.SpringPatterns;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CoffeService implements State {

    @Autowired
    CoffeRepository coffeRepository;

    public CoffeService() {
    }

    public State getState(State state)
    {
        Context context = new Context(state);
        return context.getThisState();
    }

    @Override
    public void setData(String name, int amount, Boolean milk) {
        Coffe coffe = new Coffe();
        coffe.setName(name);
        coffe.setAmount(amount);
        coffe.setMilk(milk);
        coffeRepository.save(coffe);
    }

    @Override
    public void getData(Context context) {
        List<Coffe> coffe = coffeRepository.findAll();
        System.out.println("Output by service");
        for (Coffe value : coffe) {
            System.out.println(value.getName());
        }
        ManualData manualData = new ManualData();
        context.state = manualData;
    }
}