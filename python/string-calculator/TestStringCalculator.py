import unittest

def suma (string):
	delim, sumandos = dameDelimitadorYSumandos(string)
	chequeaSumandos(delim,sumandos)
	return (sumaConDelimitador(delim,sumandos))

def dameDelimitadorYSumandos(string):
	delim = ','
	sumandos = string
	if string[:3] == '//[':
		aux = string[3:].split(']\n', 1)
		sumandos = aux.pop()
		delim = aux.pop()
	elif string[:2] == '//':
		delim = string[2]
		sumandos = string[3:]		
	return delim, sumandos

def chequeaSumandos(delim, sumandos):
	negativos = []
	if ("-" in sumandos):
		negativos = [int(n) for n in sumandos.split(delim) if int(n) < 0]
		raise Exception('negativos no soportados: ' + str(negativos))

def sumaConDelimitador (delim,string):
	return sum([int(n) for n in string.split(delim) if (n is not "") and (int(n) < 1000)])

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
		self.assertEqual(6, suma("//,\n1,2,3"))

	def testCadenaConNegativos (self):
		try:
			suma("-1,2,3,-4")
		except Exception as e:
			self.assertEqual(str(e), 'negativos no soportados: [-1, -4]')

	def testCadenaConNumerosGrandes (self):
		self.assertEqual(7, suma("1,2,1001,4"))

	def testCadenaConVariosDelimitadores (self):
		self.assertEqual(6, suma("//[..]\n1..2..3"))

if __name__ == '__main__':
	unittest.main()
