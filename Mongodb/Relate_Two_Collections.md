```javascript
const mongoose = require("mongoose");
const Schema = mongoose.Schema;

const genreSchema = Schema({
  name: String,
});

const movieSchema = Schema({
  title: String,
  genre: { type: Schema.Types.ObjectId, ref: "Genre" },
});

const Genre = mongoose.model("Genre", genreSchema);
const Movie = mongoose.model("Movie", movieSchema);
```

Next, let's define the API endpoints to create a new genre, create a new movie, and get a movie with its genre:

```javascript
const express = require("express");
const app = express();
app.use(express.json());

// Endpoint to create a new genre
app.post("/genres", async (req, res) => {
  const genre = new Genre(req.body);
  await genre.save();
  res.send(genre);
});

// Endpoint to create a new movie
app.post("/movies", async (req, res) => {
  const movie = new Movie(req.body);
  await movie.save();
  res.send(movie);
});

// Endpoint to get a movie with its genre
app.get("/movies/:id", async (req, res) => {
  const movie = await Movie.findById(req.params.id).populate("genre");
  res.send(movie);
});

app.listen(3000, () => {
  console.log(`Server Started at ${3000}`)
});
```

> and to relate the movie to a specific genre name, we only have to get that Genre Id and put `genre: genre._id` , and to show it we use `populate('genre')`