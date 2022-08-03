[TOC]

## Pagination ,Filtering & Sorting

### Using Function as the field value of an Object , 

> an object in javascript *has* `key : value` as you know .
>
> and we can use `function` , as the value of an Object property , like bellow :arrow_double_down:

```javascript
const arash = {
    name:'samandar',
    family:'aghashahi',
    content:function() {
        console.log('good job');
    }
}
// IMPORTAT : It Can Be Written Like Bellow Too :
columns = [
    {path:'title',label:'Title',content:movie => <Link to={`/movies/${movie._id}'}>{movie.title}</Link>
    {path:'genre',label:'Genres'},
    {								
        key:'Like',
        content: movie => <Like liked={movie.like} onClick{() => this.props.onLike(movie)}/>
    }
]
// and now we can also render the third object in this array , and use something like "map"
// in it .
```

### Using 'lodash' library

> lodash can convert a number to an array , like bellow :

```javascript
import _ from 'lodash';

const Pagination = (props) => {
    const {itemsCount,pageSize} = props;
    const pageCount = itemsCount / pageSize;
    const pages = _.range(1,pageCount + 1);
    return (
        <nav aria-label="Page navigation example">
            <ul className="pagination">
                {pages.map(num =>
                    <li key={num} className="page-item">
                        <a style={{cursor:"pointer"}} className="page-link">{num}</a>
                    <li>
                )}
            <ul>
        <nav>
    )
}
// for convenient in this lecture , we remove </> , so the color would be the same
// for exapmple <a></a> would be <a><a>
```

> note that an `onClick` handler , is eather implemented in the `parent` Component , or in the `child` , or `Controlled` Component , __and if it has Arguments__ , you must pass that __Argument__ eather in the `parent` or in the `child` , like bellow :

```javascript
export default class Movies extends Component {
    state = {};
    handlePageChange = (page) => { // this is the class that handles the change
        console.log(page);
    }
    render() {
        return (
        	<div>
				<Pagination onPageChange={this.handlePageChange} />
            <div>
        )
    }
}
// and we pass the argument in the child ( Pagination ) Component
const Pagination = ({page,onPageChange}) => {
    return (
    	<div>
        	<button onClick={() => onPageChange(page)}>example</button>
        <div>
    )
}
// as you see we passed the argument in the child component , but in the paretn we saw that it needs 
```

### DefaultProperty

```javascript
import React,{Component} from "react";

const ListGroup = (props) => {
    const {items,textProperty,valueProperty} = props;
    return (
        <ul className="list-group">
            {items.map(item => (
                <li key={item[valueProperty]}
                    className="list-group-item">
                    {item[textProperty]}
                </li>
            ))}
        </ul>
    )
}
ListGroup.defaultProps = { // with default property names we don't have to pass it as props
    textProperty:'name',
    valueProperty:'_id',
}
export default ListGroup;
```

### adding a new state variable out of nowhere

> earlier you saw how we added the `liked` , and we used it as it is a `boolean` value . like :
>
> ```
> movie.liked = !movie.liked; // to change the state of fa-heart-o or fa-heart
> ```

> now here we use a `selectedGenre` and we pass it as `selectedItem` , like bellow code :

```javascript
import {getMovies,getGenere} from './movieService.js';
state = {
    movies:getMovies(),
    genres:getGenre(),
    currentPage:1,
    pageSize:4,
}
handleGenreSelect = (genre) => {
        this.setState({selectedGenre:genre});
}
// as you see there is no such thing as "selectedGenre"
<div className="col-2">
     <ListGroup items={this.state.genres}
     onItemSelect={this.handleGenreSelect}
     selectedItem={this.state.selectedGenre} // this line of code came from this.setState
     />
 </div>
```

```javascript
// here is the ListGroup Component .
const ListGroup = (props) => {
    const {items,textProperty,valueProperty,selectedItem,onItemSelect} = props;
    return (
        <ul className="list-group">
            {items.map(item => (
                <li key={item[valueProperty]}
                    className={item === selectedItem ? 'list-group-item active' : 'list-group-item'}
                    onClick={() => onItemSelect(item)}
                    style={{cursor:"pointer"}}>
                    {item[textProperty]}
                </li>
            ))}
        </ul>
    )
}
```

#### Adding an object to the array

```javascript
componentDidMount() {
    const genres = [{name:'All Genres'},...getGenres()]
    this.setState({movies: getMovies(),genres})
    }
```

## Passing a prop `two level up`

> here you can see how we passed a method ( Prop ) 2 level up .

> look at `onSort` here , it is in the `movies` Component, `movies Component` passes it to the `moviesTable` and `moviesTable` passes it to the `TableHeader` .

```javascript
handleSort = (sortColumn) => { // here is movies.jsx Movies Component .
        this.setState({sortColumn});
}
return (
            <div className="row">
                <div className="col-2">
                    <ListGroup items={this.state.genres}
                    onItemSelect={this.handleGenreSelect}
                    selectedItem={this.state.selectedGenre}
                    />
                </div>
                <div className="col">
                    <MoviesTable
                        movies={moviesNumber}
                        onDelete={this.handleDelete}
                        onLike={this.handleLike}
                        onSort={this.handleSort} // : HERE : its Argument comes from the last step ( Component ) , which is TableHeader
                        sortColumn={sortColumn}
                    />
                    <Pagination
                        itemsCount={filtered.length}
                        pageSize={pageSize}
                        onPageChange={this.handlePageChange}
                        currentPage={currentPage}
                    />
                </div>

            </div>
        )
```

```javascript
// here is moviesTable Component
return (
            <table className="table">
                    <TableHeader columns={this.columns}
                                 sortColumn={sortColumn}
                                 onSort={onSort} // just passed it to the TableHeader Component
                                 />
                <tbody>
                {movies.map(movie => (
                    <tr key={movie._id}>
                        <td>{movie.title}</td>
                        <td>{movie.genre.name}</td>
                        <td>{movie.numberInStock}</td>
                        <td>{movie.dailyRentalRate}</td>
                        <td>
                            <Like
                                liked={movie.liked}
                                onClick={() => onLike(movie)}/></td>
                        <td>
                            <button
                                onClick={() => onDelete(movie)}
                                className="btn btn-danger btn-sm">
                                Delete
                            </button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        )
```

```javascript
// and here is TableHeader Component
class TableHeader extends Component{
    raiseSort = column => {
        const sortColumn = {...this.props.sortColumn};
        if(sortColumn.path === column) {
            sortColumn.order = (sortColumn.order === 'asc') ? 'desc' : 'asc';
        }
        else {
            sortColumn.path = column;
            sortColumn.order = 'asc'
        }
        this.props.onSort(sortColumn); // at last : here it is called .
    }
    render() {
        return (
            <thead>
                <tr>
                    {this.props.columns.map(column =>
                        <th key={column.path || column.key} onClick={() => this.raiseSort(column.path)}>
                            {column.label}
                        </th>
                    )}
                </tr>
            </thead>
        )
    }
}
export default TableHeader;
```

## Nested Loops of `map`

```javascript
import React, {Component} from "react";
import _ from 'lodash';

class TableBody extends Component{
    renderCell = (item,column) => {
        if(column.content) { // if column has a content
            return column.content(item) // because it is a function, we pass item to function
        } else {
            return _.get(item,column.path);
        }
    }
    render() {
        const { data,columns } = this.props;
        return (
            <tbody>
            {data.map(item => ( // item is a movie
                <tr>
                    {columns.map(column => (
                        <td>{this.renderCell(item,column)}</td>
                    ))}
                </tr>
            ))}
            </tbody>
        )
    }
}
export default TableBody;
```

> React with mosh , lesson `84` and above .

```javascript
export default class MoviesTable extends Component {
    columns = [
        {path:'title',label:'Title'},
        {path:'genre.name',label:'Genre'},
        {path:'numberInStock',label:'Stock'},
        {path:'dailyRentalRate',label: 'Rate'},
        {key:'like', content: movie => <Like liked={movie.liked} onClick={() =>         			 this.props.onLike(movie)}/>},
        {key:'delete',
        content:movie => (<button onClick={() => this.props.onDelete(movie)} className="btn btn-danger btn-sm">Delete</button>) }
    ]
    //------------------------- NOTE -----------------
        the above array of objects , would go in a `map`
        and would need a method like 'renderCell(item,column)'
		renderCell = (item,column) => { // this render cell is inside two maps one iterate over item ( which is movie ) , and one iterates over array of Objects , which is above `columns`
        if(column.content) {
            return column.content(item); // passes the item which is movie , to the content of column . which you can see both in the above array , which is column (a)
        } else {
            return _.get(item,column.path);
        }
    }
    //-------------------------End Note---------------
    render() {
        const {movies, onDelete, onLike, sortColumn, onSort} = this.props;
        return (
            <table className="table">
                    <TableHeader columns={this.columns}
                                 sortColumn={sortColumn}
                                 onSort={onSort}
                                 />
                    <TableBody data={movies} columns={this.columns}/>
            </table>
        )
    }
}
```

## Nested Loops

> like bellow :

```javascript
// this is the MoviesTable Component
export default class MoviesTable extends Component {
    columns = [
        {path:'title',label:'Title'},
        {path:'genre.name',label:'Genre'},
        {path:'numberInStock',label:'Stock'},
        {path:'dailyRentalRate',label: 'Rate'}, // item is a movie
        {key:'like', content: movie => <Like liked={movie.liked} onClick={() => this.props.onLike(movie)}/>},
        {key:'delete', content:movie => (<button onClick={() => this.props.onDelete(movie)} className="btn btn-danger btn-sm">Delete</button>) }
    ]
    render() {
        const {movies, onDelete, onLike, sortColumn, onSort} = this.props;
        return (
            <table className="table">
                    <TableHeader columns={this.columns} sortColumn={sortColumn} onSort={onSort}/>
                    <TableBody data={movies} columns={this.columns}/> // here we summon TableBody
            </table>
        )
    }
}
```

> `TableBody`

```javascript
import React, {Component} from "react";
import _ from 'lodash';

class TableBody extends Component{
    renderCell = (item,column) => {
        if(column.content) {
            return column.content(item)
        } else {
            return _.get(item,column.path); // here we used lodash , to fetch a column.path 
            								// from item , which item is a movie .
        }
    }
    createKey = (item,column) => {
        return item._id + (column.path || column.key)
    }
    render() {
        const { data,columns } = this.props;
        return (
            <tbody>
            {data.map(item => (
                <tr key={item._id}>
                    {columns.map(column => (
                        <td key={this.createKey()}>{this.renderCell(item,column)}</td>
                    ))}
                </tr>
            ))}
            </tbody>
        )
    }
}
export default TableBody;
```

> thus , if you ever had `Component` or `Button` , or any kind of `JSX Element` like <h2>arash</h2> , you still can include it in a `map` or `filter` method , just remember that we can declare a function in a `javascript object` , like bellow :

```javascript
columns = [
        {path:'title',label:'Title'},
        {path:'genre.name',label:'Genre'},
        {path:'numberInStock',label:'Stock'},
        {path:'dailyRentalRate',label: 'Rate'}, // item is a movie
        {key:'like', content: movie => <Like liked={movie.liked} onClick={() => this.props.onLike(movie)}/>},
        {key:'delete', content:movie => (<button onClick={() => this.props.onDelete(movie)} className="btn btn-danger btn-sm">Delete</button>) }
    ]
```

```javascript
// declare it like
column.content(movie); // like in bellow nested `map` :
class TableBody extends Component{
    renderCell = (item,column) => {
        if(column.content) {
            return column.content(item)
        } else {
            return _.get(item,column.path);
        }
    }
    render() {
        const { data,columns } = this.props;
        return (
            <tbody>
            {data.map(item => (
                <tr>
                    {columns.map(column => (
                        <td>{this.renderCell(item,column)}</td>
                    ))}
                </tr>
            ))}
            </tbody>
        )
    }
}
export default TableBody;
```

## Object Desturacting in methods

> for example if we have too many operations for getting several data , we can `cut` them and `put` them in a `method` , like `bellow` :
>
> unique Specification that JS has , is that a function can return multiple Values , like bellow , and when we know it , we get it in multiple Variables , like bellow :

```javascript
getPagedData = () => {
        const {length,count} = this.state.movies;
        const {pageSize,currentPage,movies,selectedGenre,sortColumn} = this.state;
        const filtered = selectedGenre && selectedGenre._id ? (movies.filter(m => m.genre._id === selectedGenre._id)) : movies;
        const sorted = _.orderBy(filtered,[sortColumn.path],[sortColumn.order])
        const moviesNumber = paginate(sorted,currentPage,pageSize);
        return {totalCount,filtered.length,moviesNumber,sorted}
    }
// and now that we know we return an object , we can get it like , bellow :
const {moviesNumber,totalCount,sorted} = this.getPagedData();
```

> NOTE : you use a method like `this.myMethod()` , meaning with its parantesis `()` , when you want the `return` from it .
>
> otherwise , in most cases when we call them , we call them without the parantesisi 
