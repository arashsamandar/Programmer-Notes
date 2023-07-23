## two types of passing arguments in react.js

> when calling it like `(movie)=>handleMovie(movie)` , arrow function is being called with one example argument like `movie`

> when calling it like `()=>handleLike(movie)` , the `handleLike` method is called with the `movie` that is passed from the surrounding area and scop

## Defining Different Functions In An Object & Using Them

```javascript
handleSort = (sortColumn) => {
        const { movies,sortedColumn } = this.state;
        const sortingFunctions = {
            title: (movieA, movieB) => movieA.title.localeCompare(movieB.title),
            genre: (movieA, movieB) => movieA.genre.name.localeCompare(movieB.genre.name),
            stock: (movieA, movieB) => movieA.numberInStock - movieB.numberInStock,
            rate: (movieA, movieB) => movieA.dailyRentalRate - movieB.dailyRentalRate,
        };
        const sortFunction = sortingFunctions[sortColumn];
        if (sortFunction) {
            if(sortedColumn === sortColumn) {
                this.setState({sortedColumn: ''});
                return movies.sort(sortFunction).reverse();
            }
            movies.sort(sortFunction);
        }
        this.setState({ movies, sortedColumn: sortColumn });
    };
```

```javascript
class Folani {
    sortMoviesBasedOnColumns = {
        tite:(movieA,movieB)=>movieA.title.localCompate(movieB),
        genre:(movieA,movieB)=>movieA.genre.localCompare(movieB),
    }
    if(columnToSort) {
        movies.sort(sortMoviesBasedOnColumns[columnToSort])
    }
}
```

## Returning multiple variables from a function

> you can simply do this like below *returning an object that has sevel fields and each field is a variable*

```react
getPagedData = () => {
        const {movies,moviesPerPage,pageNumber,GenreItem} = this.state;
        const GenreMovies = applyGenreIfNeccesary(this,GenreItem,movies);
        const paginatedMovies = paginateMovies(pageNumber,moviesPerPage,GenreMovies);
        const pagesArray = returnPagesArray(moviesPerPage,GenreMovies.length);
        return {paginatedMovies,pagesArray,GenreMovies};
    }
const {GenreMovies,paginatedMovies,pagesArray} = getPagedData();
```

