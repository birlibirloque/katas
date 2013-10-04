
const char direction_char[5] = { 'N','E','S','W', 0 };

class MarsRover {

private:


	int _x;
	int _y;
	int _direction;

	void _moveByDirection (int sense);

public:

	MarsRover ();

	MarsRover (int x, int y, char direction);

	void command (const char * commands);

	bool areYouAt (int x, int y, char direction);
};