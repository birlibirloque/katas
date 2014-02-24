import tennis
import unittest

class TestTennisGame (unittest.TestCase):

	# Create a tennis match
	def testWhenTheGameIsCreatedThenTheScoreIsLoveAll(self):
		game = tennis.TennisGame()
		self.assertEqual("love-all", game.score())

	def testGivenAGameWhenPlayer1Win1PointTheScoreIsFifteenLove(self):
		game = tennis.TennisGame()
		game.winPlayer1()
		self.assertEqual("fifteen-love", game.score())

	def testGivenAGameWhenPlayer1Win2PointsTheScoreIsThirtyLove(self):
		game = tennis.TennisGame()
		game.winPlayer1()
		game.winPlayer1()
		self.assertEqual("thirty-love", game.score())

	def testGivenAGameWhenPlayer2Win1PointsTheScoreIsLoveFifteen(self):
		game = tennis.TennisGame()
		game.winPlayer2()
		self.assertEqual("love-fifteen", game.score())

	def testGivenAGameWhenPlayer1Win2AndPlayer2Win1PointsTheScoreIsThirtyFifteen(self):
		game = tennis.TennisGame()
		game.winPlayer1()
		game.winPlayer1()
		game.winPlayer2()
		self.assertEqual("thirty-fifteen", game.score())

	def testGivenAGameWhenPlayer1Win2AndPlayer2Win2PointsTheScoreIsThirtyAll(self):
		game = tennis.TennisGame()
		game.winPlayer1()
		game.winPlayer1()
		game.winPlayer2()
		game.winPlayer2()
		self.assertEqual("thirty-all", game.score())

	def testGivenAGameWhenPlayer1Win3AndPlayer2Win3PointsTheScoreDeuce(self):
		game = tennis.TennisGame()
		game.winPlayer1()
		game.winPlayer1()
		game.winPlayer1()
		game.winPlayer2()
		game.winPlayer2()
		game.winPlayer2()
		self.assertEqual("deuce", game.score())

	def testGivenAGameWhenPlayer1Win4AndPlayer2Win4PointsTheScoreDeuce(self):
		game = tennis.TennisGame()
		game.winPlayer1()
		game.winPlayer2()
		game.winPlayer1()
		game.winPlayer2()
		game.winPlayer1()
		game.winPlayer2()
		game.winPlayer1()
		game.winPlayer2()
		self.assertEqual("deuce", game.score())

if __name__ == '__main__':
	unittest.main()
