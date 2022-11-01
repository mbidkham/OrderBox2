package functional

import com.example.orderbox2.dto.OrderCreationDto
import com.example.orderbox2.exception.RestOrderException
import com.example.orderbox2.model.enums.OrderSide
import com.example.orderbox2.model.enums.OrderType
import com.example.orderbox2.model.repository.OrderRepository
import com.example.orderbox2.service.imp.StopOrderService
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.context.annotation.ComponentScan
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@EnableAutoConfiguration
@ContextConfiguration
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2, replace = AutoConfigureTestDatabase.Replace.ANY)
@ComponentScan(value = "com.example.orderbox2")
class OrderCreationTest extends Specification {
    @Autowired OrderRepository orderRepository
    @Autowired ModelMapper modelMapper

    def "Should throw exception when Validation fails"() {
        given:
        def modelMapper = Mock(ModelMapper)
        def orderRepository = Mock(OrderRepository)
        def stopOrderService = new StopOrderService(modelMapper, orderRepository)
        def orderCreationDto = new OrderCreationDto(1000, new BigDecimal(2), OrderSide.BUY, OrderType.STOP)
        when:
        stopOrderService.createOrder(orderCreationDto)
        then:
        thrown(RestOrderException)

    }

    def "Should not create Order when Validation fails"() {
        given:
        def modelMapper = Mock(ModelMapper)
        def stopOrderService = new StopOrderService(modelMapper, orderRepository)
        def orderCreationDto = new OrderCreationDto(1000, new BigDecimal(2), OrderSide.BUY, OrderType.STOP)
        when:
        stopOrderService.createOrder(orderCreationDto)
        then:
        thrown(RestOrderException)
        orderRepository.findAll().isEmpty()

    }

    def "create order successfully"(){
        given:
        def stopOrderService = new StopOrderService(modelMapper, orderRepository)
        def orderCreationDto = new OrderCreationDto(20_000, new BigDecimal(2), OrderSide.BUY, OrderType.STOP)
        when:
        stopOrderService.createOrder(orderCreationDto)
        then:
        orderRepository.count() == old(orderRepository.count()) + 1
    }


}
