for $person in doc("persons3.xml")/People/Person
where starts-with(lower-case($person/@firstName), "d")
return $person