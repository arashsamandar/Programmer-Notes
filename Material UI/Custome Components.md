```jsx
import { styled } from '@mui/material/styles';

const MyStyledDiv = styled('div')(function(props) {
  return {
    color: 'blue',
    fontSize: '14px',
    padding: props.big ? '20px' : '10px'
  };
});

function MyComponent() {
  return <MyStyledDiv big={true}>Hello, World!</MyStyledDiv>;
}
```

