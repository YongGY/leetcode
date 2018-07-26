
/**
 * 
 * @author William
 *
 */
public class test {

	
//	Public: A class, method, constructor, interface, etc. declared public can be accessed from any other class.
//
//	Protected: Variables, methods, and constructors, which are declared protected in a superclass can be accessed only by the subclasses in other package or any class within the package of the protected members' class.
//
//	Private: Methods, variables, and constructors that are declared private can only be accessed within the declared class itself.
//
//	Rules for superclass:
//
//	Methods declared public in a superclass also must be public in all subclasses.
//	Methods declared protected in a superclass must either be protected or public in subclasses; they cannot be private.
//	Methods declared private are not inherited at all, so there is no rule for them.


//    Eliminate irrelevant classes.
//    That have no meaningful behaviour. (demote them to attributes)
//    Eliminate classes that are outside the system.
//    Imagine you have a banking system. And a Customer(class) sends messages to your ATM(class),
//    just sending messages to the ATM is not meaningful behaviour. Your ATM must be be able to receive messages, be invoked.
//    How many object-oriented developers are needed to screw a light bulb?
//            0 because and object-oriented developer will teach the light bulb to screw itself.
//    Do not turn an operation into a class.
//    Egg: Do not create a class InvertImage that contains an invertImage method. Create a class
//    Image that multiple operations related to images.
//    Be sure that the abstractions that you model are classes and not simply the roles objects play.
//    If the abstractions have different behaviour then they go into different classes.
//    Distribute the intelligence uniformly.
//    Egg: If you model a room temperature regulator, let's suppose the Room package has different classes PresenceSensor, TemperatureSensor, HumiditySensor, there is a Regulator class outside the room package and a Heater class.
//    The Regulator class should not call on the Room package: getTemperature(), isPresent(), getHumidity() then start to compute if the room needs heat or not.
//    The Regulator should only ask the Room if it needs heat, and the room class should do all the computations internally. Eventually if the room needs heat, (or not) the regulator may start/stop the Heater.

}
