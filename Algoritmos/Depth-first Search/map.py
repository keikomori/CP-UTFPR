from city import City
from adjacent import Adjacent

class Map:
    #atributos da propria classe, por que o mapa é fixo
    diamanteDoNorte = City("Diamante do Norte")
    novaLondrina = City("Nova Londrina")
    terraRica = City("Terra Rica")
    novaAurora = City("Nova Aurora")
    amapora = City("Amaporã")
    mirador = City("Mirador")
    rondon = City("Rondon")
    santoAntonioDoCaiua = City("Santo Antônio do Caiuá")
    saoJoaoDoCaiua = City("São João do Caiuá")
    paranavai = City("Paranavai")
    paraisoDoNorte = City("Paraíso do Norte")
    inaja = City("Inajá")
    cruzeiroDoSul = City("Cruzeiro do Sul")
    uniflor = City("Uniflor")
    novaEsperanca = City("Nova Esperança")
    florai = City("Florai")
    colorado = City("Colorado")
    mandaguagu = City("Mandaguaçu")
    santoInacio = City("Santo Inâcio")
    santaFe = City("Santa Fé")
    iguaracu = City("Iguaraçu")
    maringa = City("Maringa")
    centenarioDoSul = City("Centenario do Sul")
    guaraci = City("Guaraci")
    astorga = City("Astorga")

    diamanteDoNorte.addCityAdjacent(Adjacent(novaLondrina))
    diamanteDoNorte.addCityAdjacent(Adjacent(terraRica))
    
    novaLondrina.addCityAdjacent(Adjacent(novaAurora))
    novaLondrina.addCityAdjacent(Adjacent(diamanteDoNorte))
    
    terraRica.addCityAdjacent(Adjacent(diamanteDoNorte))
    terraRica.addCityAdjacent(Adjacent(novaAurora))
    terraRica.addCityAdjacent(Adjacent(santoAntonioDoCaiua))
    
    novaAurora.addCityAdjacent(Adjacent(terraRica))
    novaAurora.addCityAdjacent(Adjacent(novaLondrina))
    novaAurora.addCityAdjacent(Adjacent(amapora))
    novaAurora.addCityAdjacent(Adjacent(paranavai))
    
    amapora.addCityAdjacent(Adjacent(novaAurora))
    amapora.addCityAdjacent(Adjacent(paranavai))
    amapora.addCityAdjacent(Adjacent(mirador))
    
    mirador.addCityAdjacent(Adjacent(amapora))
    mirador.addCityAdjacent(Adjacent(paraisoDoNorte))
    mirador.addCityAdjacent(Adjacent(rondon))
    
    rondon.addCityAdjacent(Adjacent(mirador))
    rondon.addCityAdjacent(Adjacent(paraisoDoNorte))
    
    santoAntonioDoCaiua.addCityAdjacent(Adjacent(terraRica))
    santoAntonioDoCaiua.addCityAdjacent(Adjacent(saoJoaoDoCaiua))
    santoAntonioDoCaiua.addCityAdjacent(Adjacent(inaja))
    
    saoJoaoDoCaiua.addCityAdjacent(Adjacent(santoAntonioDoCaiua))
    saoJoaoDoCaiua.addCityAdjacent(Adjacent(inaja))
    saoJoaoDoCaiua.addCityAdjacent(Adjacent(cruzeiroDoSul))
    saoJoaoDoCaiua.addCityAdjacent(Adjacent(paranavai))

    
    paranavai.addCityAdjacent(Adjacent(saoJoaoDoCaiua))
    paranavai.addCityAdjacent(Adjacent(novaAurora))
    paranavai.addCityAdjacent(Adjacent(amapora))
    paranavai.addCityAdjacent(Adjacent(paraisoDoNorte))
    paranavai.addCityAdjacent(Adjacent(novaEsperanca))
    
    paraisoDoNorte.addCityAdjacent(Adjacent(paranavai))
    paraisoDoNorte.addCityAdjacent(Adjacent(mirador))
    paraisoDoNorte.addCityAdjacent(Adjacent(rondon))
    paraisoDoNorte.addCityAdjacent(Adjacent(florai))
    paraisoDoNorte.addCityAdjacent(Adjacent(novaEsperanca))
    
    inaja.addCityAdjacent(Adjacent(santoAntonioDoCaiua))
    inaja.addCityAdjacent(Adjacent(saoJoaoDoCaiua))
    inaja.addCityAdjacent(Adjacent(cruzeiroDoSul))
    inaja.addCityAdjacent(Adjacent(santoInacio))
    
    cruzeiroDoSul.addCityAdjacent(Adjacent(inaja))
    cruzeiroDoSul.addCityAdjacent(Adjacent(saoJoaoDoCaiua))
    cruzeiroDoSul.addCityAdjacent(Adjacent(uniflor))
    cruzeiroDoSul.addCityAdjacent(Adjacent(santaFe))
    cruzeiroDoSul.addCityAdjacent(Adjacent(colorado))
    
    uniflor.addCityAdjacent(Adjacent(cruzeiroDoSul))
    uniflor.addCityAdjacent(Adjacent(novaEsperanca))
    
    novaEsperanca.addCityAdjacent(Adjacent(uniflor))
    novaEsperanca.addCityAdjacent(Adjacent(paranavai))
    novaEsperanca.addCityAdjacent(Adjacent(paraisoDoNorte))
    novaEsperanca.addCityAdjacent(Adjacent(florai))
    novaEsperanca.addCityAdjacent(Adjacent(mandaguagu))
    novaEsperanca.addCityAdjacent(Adjacent(iguaracu))

    
    florai.addCityAdjacent(Adjacent(novaEsperanca))
    florai.addCityAdjacent(Adjacent(paraisoDoNorte))
    florai.addCityAdjacent(Adjacent(mandaguagu))
    florai.addCityAdjacent(Adjacent(iguaracu))
    
    colorado.addCityAdjacent(Adjacent(santoInacio))
    colorado.addCityAdjacent(Adjacent(cruzeiroDoSul))
    colorado.addCityAdjacent(Adjacent(santaFe))
    
    mandaguagu.addCityAdjacent(Adjacent(novaEsperanca))
    mandaguagu.addCityAdjacent(Adjacent(florai))
    mandaguagu.addCityAdjacent(Adjacent(maringa))
    mandaguagu.addCityAdjacent(Adjacent(iguaracu))
    
    santoInacio.addCityAdjacent(Adjacent(inaja))
    santoInacio.addCityAdjacent(Adjacent(colorado))
    santoInacio.addCityAdjacent(Adjacent(centenarioDoSul))
    
    santaFe.addCityAdjacent(Adjacent(colorado))
    santaFe.addCityAdjacent(Adjacent(cruzeiroDoSul))
    santaFe.addCityAdjacent(Adjacent(iguaracu))
    santaFe.addCityAdjacent(Adjacent(guaraci))
    
    iguaracu.addCityAdjacent(Adjacent(santaFe))
    iguaracu.addCityAdjacent(Adjacent(novaEsperanca))
    iguaracu.addCityAdjacent(Adjacent(maringa))
    iguaracu.addCityAdjacent(Adjacent(astorga))
    
    maringa.addCityAdjacent(Adjacent(iguaracu))
    maringa.addCityAdjacent(Adjacent(mandaguagu))
    
    centenarioDoSul.addCityAdjacent(Adjacent(santoInacio))
    centenarioDoSul.addCityAdjacent(Adjacent(guaraci))
    
    guaraci.addCityAdjacent(Adjacent(centenarioDoSul))
    guaraci.addCityAdjacent(Adjacent(santaFe))
    guaraci.addCityAdjacent(Adjacent(astorga))
    
    astorga.addCityAdjacent(Adjacent(guaraci))
    astorga.addCityAdjacent(Adjacent(iguaracu))


'''map = Map()
map.guaraci.visited
map.guaraci.adjacents

for i in range(len(map.guaraci.adjacents)):
    print(map.guaraci.adjacents[i].city.name)'''


