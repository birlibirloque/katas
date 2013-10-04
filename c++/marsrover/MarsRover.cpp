#include <string.h>
#include "MarsRover.h"

MarsRover::MarsRover () {
	_x = 0;
	_y = 0;
	_direction = 0;
}

MarsRover::MarsRover (int x, int y, char direction) {
	_x = x;
	_y = y;
	for (int i = 0; i < 4; i++) {
		if (direction == direction_char[i]) {
			_direction = i;
		}
	}
}

void MarsRover::command (const char * commands) {
	for (int i = 0; i < strlen(commands); i++) {
		if (commands[i] == 'f')
			_moveByDirection(1);
		else if (commands[i] == 'b')
			_moveByDirection(-1);
		else if (commands[i] == 'r')
			_direction = (_direction + 1) % 4;
		else if (commands[i] == 'l')
			_direction = (_direction + 3) % 4;
	}
}

bool MarsRover::areYouAt (int x, int y, char direction) {
	return ((_x == x) && (_y == y) && (direction_char[_direction] == direction));
}

void MarsRover::_moveByDirection (int sense) {
	if (direction_char[_direction] == 'N') {
		_y += sense;
	}

	else if (direction_char[_direction] == 'S') {
		_y -= sense;
	}

	else if (direction_char[_direction] == 'E') {
		_x += sense;
	}

	else if (direction_char[_direction] == 'W') {
		_x -= sense;
	}
}
