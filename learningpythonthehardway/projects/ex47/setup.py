try:
    from setuptools import setup
except ImportError:
    from distutils.core import setup

config = {
    'description': 'My Project',
    'author': 'My Name',
    'url': 'URL to get it',
    'version': '0.1',
    'packages': ['NAME'],
    'scripts': [],
    'name': 'projectname'
}

setup(**config)
