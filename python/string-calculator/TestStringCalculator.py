import unittest
import re

def suma (string):
	sumandos = dameSumandos(string)
	chequeaSumandos(sumandos)
	return sum(sumandos)

def dameSumandos(string):
	if (tieneDelimitadores(string)):
		string = dameSumandosSinDelimitadores(string)
	return [int(n) for n in string.strip('\n').split(',') if (n is not "") and (int(n) < 1000)]

def tieneDelimitadores(string):
	return string[:2] == '//'

def dameSumandosSinDelimitadores(string):
	s_delimitadores = string.split('\n',1)[0].strip('/')
	l_delimitadores = re.findall(r'\[([^]]*)\]', s_delimitadores)
	if (len(l_delimitadores) == 0):
		l_delimitadores.append(s_delimitadores)
	string = cambiaDelimitadoresPorComas(string,l_delimitadores)
	return string

def cambiaDelimitadoresPorComas(string,delimitadores):
	string = string.split('\n',1)[1]
	for d in delimitadores:
		string = string.replace(d,',')
	return string

def chequeaSumandos(sumandos):
	negativos = [n for n in sumandos if n < 0]
	if (len(negativos)>0):
		raise Exception('negativos no soportados: ' + str(negativos))

class TestStringCalculator (unittest.TestCase):

	def testCadenaVacia (self):
		self.assertEqual(0, suma(""))

	def testCadenaDeUnDigito (self):
		self.assertEqual(1, suma("1"))

	def testCadenaDosDigitos (self):
		self.assertEqual(3, suma("1,2"))

	def testCadenaNDigitos (self):
		self.assertEqual(10, suma("1,2,3,4"))

	def testCadenaConSaltosDeLinea (self):
		self.assertEqual(6, suma("1,\n2,3"))

	def testCadenaConDelimitador (self):
		self.assertEqual(6, suma("//:\n1:2:3"))

	def testCadenaConNegativos (self):
		with self.assertRaises(Exception) as context:
			suma("-1,2,3,-4")
		self.assertEqual(str(context.exception), 'negativos no soportados: [-1, -4]')

	def testCadenaConNumerosGrandes (self):
		self.assertEqual(7, suma("1,2,1001,4"))

	def testCadenaConDelimitadorDeCualquierLongitud (self):
		self.assertEqual(6, suma("//[***]\n1***2***3"))

	def testCadenaConDelimitadorDeCualquierLongitudYSalto (self):
		self.assertEqual(6, suma("//[***]\n1***2\n***3"))

	def testCadenaConVariosDelimitadores (self):
		self.assertEqual(6, suma("//[*][%]\n1*2%3"))

	def testCadenaConVariosDelimitadoresDeCualquierLongitud (self):
		self.assertEqual(6, suma("//[:;.][---]\n1:;.2---3"))

if __name__ == '__main__':
	unittest.main()
