import unittest

def dameDelimitadorYSumandos(string):
	delim = ','
	sumandos = string
	if string[:2] == '//':
		delim = string[2]
		sumandos = string[3:]
	return delim, sumandos

def add1 (delim,string):
	return sum([int(n) for n in string.split(delim) if n is not ""])

def add (string):
	delim, sumandos = dameDelimitadorYSumandos(string)
	return (add1(delim,sumandos))

class TestStringCalculator (unittest.TestCase):

	def testDadaUnaCadenaVaciaEntoncesSuSumaDaCero (self):
		self.assertEqual(0, add(""))

	def testDadaUnaCadenaDeUnDigitoEntoncesSuSumaDaElDigito (self):
		self.assertEqual(1, add("1"))

	def testDadaUnaCadenaDeDosDigitosEntoncesSuSumaDaLaSuma (self):
		self.assertEqual(3, add("1,2"))

	def testDadaUnaCadenaDeNDigitosEntoncesSuSumaDaLaSumaDeN (self):
		self.assertEqual(10, add("1,2,3,4"))

	def testDadaUnaCadenaDeNDigitosYSaltosEntoncesSuSumaDaLaSumaDeN (self):
		self.assertEqual(6, add("1,\n2,3"))

	def testDadaUnaCadenaDeNDigitosYDelimitadoresEntoncesSuSumaDaLaSumaDeN (self):
		self.assertEqual(6, add("//,\n1,2,3"))

	def testDadaUnaCadenaDeNDigitosNegativos (self):
		self.assertRaises(Exception, add("-1,1,2,3"))


if __name__ == '__main__':
	unittest.main()
