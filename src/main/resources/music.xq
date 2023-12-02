for $band in doc("music.xml")/music/band
where $band/@name = "The DOORS"
return
    for $artist in $band/artist
    return concat($artist/@firstName, ' ', $artist/@lastName, '&#xa;')