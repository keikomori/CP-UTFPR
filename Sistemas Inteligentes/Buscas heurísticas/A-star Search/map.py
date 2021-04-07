#https://www.adistanciaentre.com/

from city import City
from adjacent import Adjacent

class Map:
    #atributos da propria classe, por que o mapa é fixo
    #distancia em linha reta
    diamanteDoNorte = City("Diamante do Norte", 150)
    novaLondrina = City("Nova Londrina", 137)
    terraRica = City("Terra Rica", 121)
    novaAurora = City("Nova Aurora", 188)
    amapora = City("Amaporã", 60)
    mirador = City("Mirador", 40)
    rondon = City("Rondon", 0)
    santoAntonioDoCaiua = City("Santo Antônio do Caiuá", 99)
    saoJoaoDoCaiua = City("São João do Caiuá", 85)
    paranavai = City("Paranavai", 55)
    paraisoDoNorte = City("Paraíso do Norte", 25)
    inaja = City("Inajá", 114)
    cruzeiroDoSul = City("Cruzeiro do Sul", 108)
    uniflor = City("Uniflor", 94)
    novaEsperanca = City("Nova Esperança", 78)
    florai = City("Florai", 60)
    colorado = City("Colorado", 132)
    mandaguagu = City("Mandaguaçu", 101)
    santoInacio = City("Santo Inâcio", 161)
    santaFe = City("Santa Fé", 136)
    iguaracu = City("Iguaraçu", 126)
    maringa = City("Maringa", 121)
    centenarioDoSul = City("Centenario do Sul", 183)
    guaraci = City("Guaraci", 157)
    astorga = City("Astorga", 145)

    diamanteDoNorte.addCityAdjacent(Adjacent(novaLondrina, 24))
    diamanteDoNorte.addCityAdjacent(Adjacent(terraRica, 29))

    novaLondrina.addCityAdjacent(Adjacent(novaAurora, 250))
    novaLondrina.addCityAdjacent(Adjacent(diamanteDoNorte, 24))

    terraRica.addCityAdjacent(Adjacent(diamanteDoNorte, 29))
    terraRica.addCityAdjacent(Adjacent(novaAurora, 308))
    terraRica.addCityAdjacent(Adjacent(santoAntonioDoCaiua, 31))

    novaAurora.addCityAdjacent(Adjacent(terraRica, 308))
    novaAurora.addCityAdjacent(Adjacent(novaLondrina, 250))
    novaAurora.addCityAdjacent(Adjacent(amapora, 230))
    novaAurora.addCityAdjacent(Adjacent(paranavai, 242))

    amapora.addCityAdjacent(Adjacent(novaAurora, 230))
    amapora.addCityAdjacent(Adjacent(paranavai, 50))
    amapora.addCityAdjacent(Adjacent(mirador, 20))

    mirador.addCityAdjacent(Adjacent(amapora, 20))
    mirador.addCityAdjacent(Adjacent(paraisoDoNorte, 15))
    mirador.addCityAdjacent(Adjacent(rondon, 40))

    rondon.addCityAdjacent(Adjacent(mirador, 40))
    rondon.addCityAdjacent(Adjacent(paraisoDoNorte, 24))

    santoAntonioDoCaiua.addCityAdjacent(Adjacent(terraRica, 31))
    santoAntonioDoCaiua.addCityAdjacent(Adjacent(saoJoaoDoCaiua, 15))
    santoAntonioDoCaiua.addCityAdjacent(Adjacent(inaja, 17))

    saoJoaoDoCaiua.addCityAdjacent(Adjacent(santoAntonioDoCaiua, 15))
    saoJoaoDoCaiua.addCityAdjacent(Adjacent(inaja, 30))
    saoJoaoDoCaiua.addCityAdjacent(Adjacent(cruzeiroDoSul, 34))
    saoJoaoDoCaiua.addCityAdjacent(Adjacent(paranavai, 33))


    paranavai.addCityAdjacent(Adjacent(saoJoaoDoCaiua, 33))
    paranavai.addCityAdjacent(Adjacent(novaAurora, 242))
    paranavai.addCityAdjacent(Adjacent(amapora, 50))
    paranavai.addCityAdjacent(Adjacent(paraisoDoNorte, 34))
    paranavai.addCityAdjacent(Adjacent(novaEsperanca, 40))

    paraisoDoNorte.addCityAdjacent(Adjacent(paranavai, 34))
    paraisoDoNorte.addCityAdjacent(Adjacent(mirador, 15))
    paraisoDoNorte.addCityAdjacent(Adjacent(rondon, 24))
    paraisoDoNorte.addCityAdjacent(Adjacent(florai, 40))
    paraisoDoNorte.addCityAdjacent(Adjacent(novaEsperanca, 58))

    inaja.addCityAdjacent(Adjacent(santoAntonioDoCaiua, 17))
    inaja.addCityAdjacent(Adjacent(saoJoaoDoCaiua, 30))
    inaja.addCityAdjacent(Adjacent(cruzeiroDoSul, 24))
    inaja.addCityAdjacent(Adjacent(santoInacio, 57))

    cruzeiroDoSul.addCityAdjacent(Adjacent(inaja, 24))
    cruzeiroDoSul.addCityAdjacent(Adjacent(saoJoaoDoCaiua, 34))
    cruzeiroDoSul.addCityAdjacent(Adjacent(uniflor, 15))
    cruzeiroDoSul.addCityAdjacent(Adjacent(santaFe, 50))
    cruzeiroDoSul.addCityAdjacent(Adjacent(colorado, 26))

    uniflor.addCityAdjacent(Adjacent(cruzeiroDoSul, 15))
    uniflor.addCityAdjacent(Adjacent(novaEsperanca, 16))

    novaEsperanca.addCityAdjacent(Adjacent(uniflor, 16))
    novaEsperanca.addCityAdjacent(Adjacent(paranavai, 40))
    novaEsperanca.addCityAdjacent(Adjacent(paraisoDoNorte, 58))
    novaEsperanca.addCityAdjacent(Adjacent(florai, 26))
    novaEsperanca.addCityAdjacent(Adjacent(mandaguagu, 21))
    novaEsperanca.addCityAdjacent(Adjacent(iguaracu, 48))


    florai.addCityAdjacent(Adjacent(novaEsperanca, 26))
    florai.addCityAdjacent(Adjacent(paraisoDoNorte, 40))
    florai.addCityAdjacent(Adjacent(mandaguagu, 27))
    florai.addCityAdjacent(Adjacent(iguaracu, 63))

    colorado.addCityAdjacent(Adjacent(santoInacio, 30))
    colorado.addCityAdjacent(Adjacent(cruzeiroDoSul, 26))
    colorado.addCityAdjacent(Adjacent(santaFe, 40))

    mandaguagu.addCityAdjacent(Adjacent(novaEsperanca, 21))
    mandaguagu.addCityAdjacent(Adjacent(florai, 27))
    mandaguagu.addCityAdjacent(Adjacent(maringa, 32))
    mandaguagu.addCityAdjacent(Adjacent(iguaracu, 48))

    santoInacio.addCityAdjacent(Adjacent(inaja, 57))
    santoInacio.addCityAdjacent(Adjacent(colorado, 30))
    santoInacio.addCityAdjacent(Adjacent(centenarioDoSul, 28))

    santaFe.addCityAdjacent(Adjacent(colorado, 40))
    santaFe.addCityAdjacent(Adjacent(cruzeiroDoSul, 50))
    santaFe.addCityAdjacent(Adjacent(iguaracu, 22))
    santaFe.addCityAdjacent(Adjacent(guaraci, 21))

    iguaracu.addCityAdjacent(Adjacent(santaFe, 22))
    iguaracu.addCityAdjacent(Adjacent(novaEsperanca, 48))
    iguaracu.addCityAdjacent(Adjacent(maringa, 29))
    iguaracu.addCityAdjacent(Adjacent(astorga, 18))

    maringa.addCityAdjacent(Adjacent(iguaracu, 29))
    maringa.addCityAdjacent(Adjacent(mandaguagu, 48))

    centenarioDoSul.addCityAdjacent(Adjacent(santoInacio, 28))
    centenarioDoSul.addCityAdjacent(Adjacent(guaraci, 20))

    guaraci.addCityAdjacent(Adjacent(centenarioDoSul, 20))
    guaraci.addCityAdjacent(Adjacent(santaFe, 21))
    guaraci.addCityAdjacent(Adjacent(astorga, 45))

    astorga.addCityAdjacent(Adjacent(guaraci, 45))
    astorga.addCityAdjacent(Adjacent(iguaracu, 18))
