for $person in doc("persons3.xml")/People/Person
where xs:date($person/@birthDate) >= xs:date("1980-01-01") and xs:date($person/@birthDate) <= xs:date("1989-12-31")
return $person