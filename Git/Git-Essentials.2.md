## How to revert ( Only one file or two ) Back To Your Last Commit

```javascript
// imagin a merge with no `commit` made ( so you can turn back and Unstage some files )
git merge --no-commit --no-ff my-branch
// then review the files and exclude the ones you don't want ( reset them back to were the where )
git reset HEAD /path/to/file.php
// remove all changes to the file alltogether
git checkout -- /path/to/file.php
// and then commit
git commit -m "my manuall overwrite of the branch merge"
```

> you may also use `.gitattributes and put the files in it you do not want to be merged ( in case of any conflicts )

```javascript
touch .gitattributes
nano .gitattributes
// add bellow lines ( define a driver name like `ours` )
example.txt merge=ours
/path/to/folan.php merge=ours
/path/to/bahman.php merge=ours
*.log merge=ours
// the `git add .gitattributes && git commit .gitattributes -m "custom merge added"`

// then set `git config` to use this driver `ours` for our merge
git config --global merge.ours.driver true
```

## To Unstage a File ( and get it back to were it was even after merge Conflict )

```
git restore /path/to/myfile.php
```



