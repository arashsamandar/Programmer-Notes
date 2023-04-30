## Fetch Function

> fetch without __async and await__ and with __then__

```javascript
fetch('rainbow')
.then(response => {
    console.log(response);
    return response.blob()
})
.then(blob => {
    console.log(blob)
    document.getElementById('imgblob').src = URL.createObjectURL(blob);
})
.catch(error => {
    console.error(error);
})
```

> with __async and await__

```javascript
async function catchRainbow() {
    const response = await fetch('image.jpeg');
    const blob = await response.blob();
    document.getElementById('imgblob').src = URL.createObjectURL(blob);
}
catchRainbow()
.then(response => {
    console.log('yay')
})
.catch(error => {
    console.log('error!');
    console.error(error);
}).
```

## Example

```javascript
const api_url = 'https://api.covid19api.com/summary';
        async function getData(url) {
            const response = await fetch(url);
            const data = await response.json();
            return data;
        }  
        getData(api_url).then(response => {
            console.log(response.Global.NewDeaths);
        });
```

