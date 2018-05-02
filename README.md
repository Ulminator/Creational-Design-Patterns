https://app.pluralsight.com/player?course=design-patterns-java-creational&author=bryan-hansen&name=design-patterns-java-creational-m2-singleton&clip=12&mode=live

Pattern Groups

Creational - Structural - Behavioral

Creational Patterns

Singleton
Builder
Prototype
Factory
Abstract Factory


Singleton
---------
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
    
Factory
-------
- Returns various instances
    - Multiple constructors
- Interface driven
- Adaptable to environment more easily