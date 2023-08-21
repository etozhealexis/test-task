package ru.etozhealexis.test_task.config.statemachine;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;
import ru.etozhealexis.test_task.config.statemachine.event.PaymentEvent;
import ru.etozhealexis.test_task.config.statemachine.state.PaymentState;

import java.util.EnumSet;

/**
 * конфигурационный класс spring state machine
 * успел сконфигурировать по диаграмме, воплотить - нет
 */

@Configuration
@EnableStateMachineFactory
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<PaymentState, PaymentEvent> {

    @Override
    public void configure(final StateMachineConfigurationConfigurer<PaymentState, PaymentEvent> config) throws Exception {
        StateMachineListenerAdapter<PaymentState, PaymentEvent> adapter = new StateMachineListenerAdapter<>() {
            @Override
            public void stateChanged(State<PaymentState, PaymentEvent> from,
                                     State<PaymentState, PaymentEvent> to) {
                super.stateChanged(from, to);
            }
        };

        config
                .withConfiguration()
                .autoStartup(false)
                .listener(adapter);
    }

    @Override
    public void configure(final StateMachineStateConfigurer<PaymentState, PaymentEvent> states) throws Exception {
        states
                .withStates()
                .initial(PaymentState.CLIENT)
                .states(EnumSet.allOf(PaymentState.class))
                .end(PaymentState.BANK);
    }

    @Override
    public void configure(final StateMachineTransitionConfigurer<PaymentState, PaymentEvent> transitions) throws Exception {
        transitions
                .withExternal().source(PaymentState.CLIENT).target(PaymentState.SHOP_PAID).event(PaymentEvent.SHOP_PAY)
                .and()
                .withExternal().source(PaymentState.CLIENT).target(PaymentState.ONLINE_PAID).event(PaymentEvent.ONLINE_PAY)
                .and()
                .withExternal().source(PaymentState.SHOP_PAID).target(PaymentState.BANK).event(PaymentEvent.BANK_BONUS_SHOP)
                .and()
                .withExternal().source(PaymentState.ONLINE_PAID).target(PaymentState.BANK).event(PaymentEvent.BANK_BONUS_ONLINE)
                .and()
                .withExternal().source(PaymentState.ONLINE_PAID).target(PaymentState.REFUND).event(PaymentEvent.ONLINE_REFUND)
                .and()
                .withExternal().source(PaymentState.REFUND).target(PaymentState.BANK).event(PaymentEvent.BANK_COMMISSION)
                .and()
                .withExternal().source(PaymentState.BANK).target(PaymentState.CLIENT).event(PaymentEvent.BANK_BONUS_CLIENT);
    }

}
