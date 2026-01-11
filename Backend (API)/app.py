from flask import Flask, request, jsonify
import mysql.connector
import time
from flask_cors import CORS
from meta_ai_api import MetaAI

app = Flask(__name__)
CORS(app)

# Update with your actual database connection details
def get_db_cursor():
    db = mysql.connector.connect(
        host="host",
        user="user",
        password="password",
        database="database"
    )
    return db, db.cursor(dictionary=True)

@app.route('/register', methods=['POST'])
def register_user():
    try:
        data = request.get_json(force=True)
    except Exception:
        return jsonify({"error": "Invalid JSON"}), 400

    name = data.get('full_name')
    age = data.get('age')
    gender = data.get('gender')
    b_group = data.get('b_group')
    email = data.get('email')
    phone = data.get('phone')
    language = data.get('language')
    e_contact = data.get('e_contact')
    e_relation = data.get('e_relation')
    location = data.get('location')
    nationality = data.get('nationality')
    user_id = data.get('user_id')
    ts = int(time.time() * 1000)

    if not (name and age and gender and email and phone):
        return jsonify({"error": "Missing required fields"}), 400

    try:
        db, cursor = get_db_cursor()
        query = """INSERT INTO users (name, age, gender, b_group, email, phone, language, e_contact, e_relation, location, nationality, timestamp, user_id) VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)"""

        cursor.execute(query, (name, age, gender, b_group, email, phone, language, e_contact, e_relation, location, nationality, ts, user_id))
        db.commit()
    except mysql.connector.Error as err:
        return jsonify({"error": f"Database error: {err}"}), 500
    finally:
        try:
            cursor.close()
            db.close()
        except:
            pass

    return jsonify({"status": "ok", "timestamp": ts}), 201

# Endpoint to insert location
@app.route('/location/update', methods=['POST'])
def update_location():
    try:
        data = request.get_json(force=True)
    except Exception:
        return jsonify({"error": "Invalid JSON"}), 400

    user_id = data.get('user_id')
    latitude = data.get('latitude')
    longitude = data.get('longitude')
    ts = int(time.time() * 1000)

    if not (user_id and latitude and longitude):
        return jsonify({"error": "Missing fields: user_id, latitude, longitude"}), 400

    try:
        db, cursor = get_db_cursor()
        query = """INSERT INTO user_locations (user_id, latitude, longitude, timestamp)
                   VALUES (%s, %s, %s, %s)"""
        cursor.execute(query, (user_id, latitude, longitude, ts))
        db.commit()
    except mysql.connector.Error as err:
        return jsonify({"error": f"Database error: {err}"}), 500
    finally:
        try:
            cursor.close()
            db.close()
        except:
            pass

    return jsonify({"status": "ok", "timestamp": ts}), 201

# Endpoint to fetch history
@app.route('/location/history/<user_id>', methods=['GET'])
def get_history(user_id):
    try:
        db, cursor = get_db_cursor()
        query = """SELECT latitude, longitude, timestamp
                   FROM user_locations
                   WHERE user_id=%s
                   ORDER BY timestamp ASC"""
        cursor.execute(query, (user_id,))
        rows = cursor.fetchall()
    except mysql.connector.Error as err:
        return jsonify({"error": f"Database error: {err}"}), 500
    finally:
        try:
            cursor.close()
            db.close()
        except:
            pass

    if not rows:
        return jsonify({"error": "No location history found for this user"}), 404

    return jsonify(rows), 200

@app.route('/ai', methods=['POST'])
def ai_response():
    try:
        data = request.get_json(force=True)
    except Exception:
        return jsonify({"error": "Invalid JSON"}), 400

    query = data.get('query')
    if not query:
        return jsonify({"error": "Missing fields: query"}), 400

    try:
        ai = MetaAI()
        response = ai.prompt(message=query)["message"]
        print(response)
    except Exception as err:
        return jsonify({"error": f"AI error: {err}"}), 500

    return jsonify({"response": response}), 200

@app.route('/details/<user_id>', methods=['GET'])
def get_data(user_id):
    try:
        db, cursor = get_db_cursor()
        query = """SELECT user_id, name, age, gender, b_group, email, phone,
                          language, e_contact, e_relation, location, nationality, timestamp
                   FROM users
                   WHERE user_id=%s"""
        cursor.execute(query, (user_id,))
        row = cursor.fetchone()
    except mysql.connector.Error as err:
        return jsonify({"error": f"Database error: {err}"}), 500
    finally:
        try:
            cursor.close()
            db.close()
        except:
            pass

    if not row:
        return jsonify({"error": "No user found with this ID"}), 404

    return jsonify(row), 200


# Endpoint to fetch users
@app.route('/users', methods=['GET'])
def get_users():
    try:
        db, cursor = get_db_cursor()
        query = """SELECT name, user_id, email FROM users"""
        cursor.execute(query)
        rows = cursor.fetchall()
    except mysql.connector.Error as err:
        return jsonify({"error": f"Database error: {err}"}), 500
    finally:
        try:
            cursor.close()
            db.close()
        except:
            pass

    if not rows:
        return jsonify({"error": "No User Available"}), 404

    return jsonify(rows), 200

# Health check
@app.route('/')
def index():
    return jsonify({"status": "running"}), 200

# Global error handlers
@app.errorhandler(404)
def not_found(e):
    return jsonify({"error": "Endpoint not found"}), 404

@app.errorhandler(405)
def method_not_allowed(e):
    return jsonify({"error": "Method not allowed"}), 405

if __name__ == "__main__":
    app.run(debug=True)