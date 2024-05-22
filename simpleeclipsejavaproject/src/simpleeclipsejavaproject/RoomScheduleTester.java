package simpleeclipsejavaproject;

	import itech2306.lab6.Movie;
	import itech2306.lab6.RoomSchedule;
	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;
	import static org.junit.jupiter.api.Assertions.*;

	public class RoomScheduleTester {
	    Movie movie1;
	    Movie movie2;
	    RoomSchedule rs2;

	    @BeforeEach
	    public void setup() {
	        movie1 = new Movie("Harry Potter", 20.01, 14.30, 176);
	        movie2 = new Movie("Superman", 18.0, 12.50, 122);
	        rs2 = new RoomSchedule();
	        rs2.addMovie(movie1);
	        rs2.addMovie(movie1);
	        rs2.addMovie(movie2);
	        rs2.addMovie(movie2);
	    }

	    @Test
	    public void testAddMovies1() {
	        RoomSchedule rs1 = new RoomSchedule();
	        assertTrue(rs1.addMovie(movie1));
	        assertTrue(rs1.addMovie(movie2));
	    }

	    @Test
	    public void testAddMoviesTooMany() {
	        assertTrue(rs2.addMovie(movie1)); // Fifth movie
	        assertTrue(rs2.addMovie(movie2)); // Sixth movie
	        assertFalse(rs2.addMovie(movie2)); // Seventh attempt should fail
	    }

	    @Test
	    public void testGetMovie1() {
	        assertSame(movie1, rs2.getMovie(0));
	        assertSame(movie2, rs2.getMovie(3));
	        assertNull(rs2.getMovie(4));
	    }

	    @Test
	    public void testGetMovieNone() {
	        RoomSchedule rs1 = new RoomSchedule();
	        for (int i = 0; i < 6; i++) {
	            assertNull(rs1.getMovie(i));
	        }
	    }

	    @Test
	    public void testAddFirstMovie() {
	        RoomSchedule rs1 = new RoomSchedule();
	        assertNull(rs1.getMovie(0));
	        assertTrue(rs1.addMovie(movie1));
	        assertSame(movie1, rs1.getMovie(0));
	    }
	}

}
