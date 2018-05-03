#Creational Patterns

Singleton
---------

- Concepts
    - Only one instance created
    - Guarantees control of a resource
    - Lazily loaded
    - Examples: 
	    - Runtime
    	- Logger
    	- Spring Beans
    	- Graphics Managers

Class is responsible for creating itself and managing its lifecycle
Static in nature
Needs to be thread safe
Private instance
Private constructor
No parameters required for construction

Pitfalls
- Often overused
    - Don't expose an interface and have private constructors, as well as private member
    variables they can be difficult to unit test.
- Difficult to unit test
- If not careful, not thread-safe
- Sometimes confused for Factory
    - If it needs an argument in that method, it is a factory.
    
Builder
-------

- Concepts
    - Handles complex constructors
    - Large number of parameters
    - Force immutability once created
    - Works with legacy code
    - Examples:
        - StringBuilder
        - DocumentBuilder
        - Locale.Builder

Telescoping Constructors - Creation of multiple constructors wiht each parameter variation

- Flexibility over telescoping constructors
- Static inner class
- Calls appropriate constructor
- Negates need for exposed setters
- Can take advantage of generics

Prototype
---------
- Implemented around a clone
- Avoids calling complex constructors
- Difficult to implement in legacy code

- Concepts
    - Avoids costly construction
    - Avoids subclassing
    - Typically does not use "new"
    - Often utilizes an Interface
    - Usually implemented in a Registry
    - Example:
        - java.lang.Object#clone()
    
- Pitfalls
    - Somewhat not clear when to use
        - Application creates a lot of objects
    - Used with other patterns
        - Registry
    - Shallow VS Deep Copy

Factory
-------
- Returns various instances
    - Multiple constructors
- Interface driven
- Adaptable to environment more easily

- Concepts
    - Does not expose instantiation logic
    - Defer to subclass
    - Common interface
    - Specified by architecture, implemented by user
    - Examples:
        - Calendar
        - ResourceBundle
        - NumberFormat
        
- Responsible for lifecycle
- Common Interface
- Concrete Classes
- Parameterized create method

- Pitfalls
    - Complexity
    - Creation in subclass
    - Refactoring (Need to design at beginning and plan accordingly)
    
Abstract Factory
----------------
- Concepts
    - Factory of Factories
    - Factory of related objects
    - Common Interface
    - Defer to Subclasses
    - Examples:
        - DocumentBuilder
        - Frameworks
        
- Pitfalls
    - Complexity
    - Runtime switch
    - Pattern within a pattern
    - Problem specific
    - Starts as a Factory