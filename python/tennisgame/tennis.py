
class TennisGame:


	def __init__(self):
		self.player1score = 0
		self.player2score = 0
		self.gameScore = {}
		self.gameScore[(0)] = "love"
		self.gameScore[(1)] = "fifteen"
		self.gameScore[(2)] = "thirty"
		self.gameScore[(3)] = "forty"
		self.gameScore[(4)] = "game"

	def arePlayersInDeuce(self):
		return self.hasSameScore and self.player1score > 2

	def hasSameScore(self):
		return self.player1score == self.player2score


	def score(self):
		if self.arePlayersInDeuce():
			return "deuce"
		if self.hasSameScore():
			return self.gameScore[self.player1score] + "-all"
		return self.gameScore[self.player1score] + "-" + self.gameScore[self.player2score]

	def winPlayer1(self):
		self.player1score = self.player1score + 1;

	def winPlayer2(self):
		self.player2score = self.player2score + 1;